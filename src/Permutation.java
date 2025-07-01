public class Permutation {
    public static void printPerm (String str, int idx, String permutation) {
        if (idx == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String  newStr = str.substring(0,i) + str.substring(i+1);
            printPerm(newStr, idx+1, permutation + currentChar);
        }

    }
    public static void main (String [] args) {
        String str = "ABC";
    }
}