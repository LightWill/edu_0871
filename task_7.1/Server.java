package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream incoming = new DataInputStream(socket.getInputStream());
                DataOutputStream outgoing = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключен.");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            outgoing.writeUTF("Укажите ваше имя:");
                            String name = incoming.readUTF();
                            System.out.println("name: " + name);

                            Client client = new Client(name, socket);
                            clients.add(client);

                            while (true) {
                                String str = incoming.readUTF();
                                broadcastMsg(str);
                                System.out.println("Клиент прислал сообщение2: " + str);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMsg(String str) {
        DataOutputStream outgoing;
        for (Client client: clients) {
            client.send(str);
        }
    }

    public static void sendToClient(String name, String text) {
        for (Client client: clients) {
            if (client.name.equals(name)) {
                client.send(text);
                break;
            }
        }
    }

}

class Client {
    String name;
    Socket socket;

    Client(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    void send(String text) {
        DataOutputStream outgoing;
        try {
            outgoing = new DataOutputStream(socket.getOutputStream());
            outgoing.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
