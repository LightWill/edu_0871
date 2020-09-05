import java.util.HashSet;

public class AllPossiblePlaces {

    public static void main(String[] args) {
        allPlaces();
    }

    static void allPlaces() {
        String[] array = {"Мама", "Мыла", "Раму", "Папу"};
        int quantityOfElements = array.length;

        int[] combination = new int[quantityOfElements];
        for (int i = 0; i < combination.length; i++) {
            combination[i] = 0;
        }

        int ammountOfReplaces = 1;
        for (int i = 0; i < quantityOfElements; i++) {
            ammountOfReplaces = ammountOfReplaces * quantityOfElements;
        }

        int[][] allPossibleCombinations = new int[ammountOfReplaces][quantityOfElements];
        for (int i = 1; i < ammountOfReplaces; i++) {
            int position = quantityOfElements - 1;
            boolean con = true;

            while (con) {
                int test = combination[position] + 1;

                if (test < quantityOfElements) {
                    combination[position] = test;
                    con = false;
                } else {
                    combination[position] = 0;
                    position = position - 1;
                }
            }

            for (int j = 0; j < combination.length; j++) {
                allPossibleCombinations[i][j] = combination[j];
            }
        }

//        for (int i = 0; i < allPossibleCombinations.length; i++) {
//            for (int j = 0; j < allPossibleCombinations[j].length; j++) {
//                System.out.print(allPossibleCombinations[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(allPossibleCombinations.length);

        for (int i = 0; i < allPossibleCombinations.length; i++) {
            HashSet<Integer> setTocheck = new HashSet<>();
            for (int j = 0; j < allPossibleCombinations[i].length; j++) {
                setTocheck.add(allPossibleCombinations[i][j]);
            }

            if (setTocheck.size() == allPossibleCombinations[i].length) {
                for (int j = 0; j < allPossibleCombinations[i].length; j++) {
//                    System.out.print(allPossibleCombinations[i][j] + " ");
                    System.out.print(array[allPossibleCombinations[i][j]] + " ");
                }
                System.out.println();
            }
        }

    }

}
