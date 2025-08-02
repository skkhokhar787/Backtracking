import java.util.*;

public class Permutation {
    static List<String> permutations = new ArrayList<>();

    public static void printPerm(String str, String permutation) {
        if (str.isEmpty()) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, permutation + currentChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printPerm(str, "");
        System.out.println("Last permutation: " + permutations.get(permutations.size() - 1));
    }
}