//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Arrays;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] words = WorkWithProxyFile.readWords("/Users/Shared/qwe.txt");

        for (int i = 0; i < words.length; i++) {
            String[] ipWithPort = words[i].split(":");
            String ip = ipWithPort[0];
            int port = Integer.parseInt(ipWithPort[1]);

//            ProxyCheckerN1 thread = new ProxyCheckerN1(ip, port); // First approach

//            Thread thread = new Thread(new ProxyCheckerN2(ip, port)); // Second approach

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ProxyChecker.checkProxy(ip, port);
                }
            }); // Third approach

            thread.start();
        }

    }

}

class WorkWithProxyFile {

    static String[] readWords(String path) {
        Path fileName = Path.of(path);

        try {
            String content = Files.readString(fileName);
            String[] words = content.split("\n");
            return words;
        } catch (Exception except) {
            System.out.println("Ошибка:" + except);
        }

        return null;
    }

}

class ProxyCheckerN1 extends Thread {

    String ip;
    int port;

    ProxyCheckerN1(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override public void run() {
        System.out.println(getName());
        ProxyChecker.checkProxy(ip, port);
    }

}

class ProxyCheckerN2 implements Runnable {
    String ip;
    int port;

    ProxyCheckerN2(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
//        System.out.println(getName());
        ProxyChecker.checkProxy(ip, port);
    }

}

class ProxyChecker {

    static void checkProxy(String ip, int port) { //throws Exception
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);

            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;

            StringBuilder sb = new StringBuilder();

            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);

            reader.close();

            System.out.println(sb);
        } catch (Exception e) {
            System.out.println("ip" + ip + ":" + port + " is dead");
        }
    }

}
