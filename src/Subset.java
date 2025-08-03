import java.util.ArrayList;

public class Subset {
    public static void printSubset (ArrayList<Integer> subset) {
        for (Integer integer : subset) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void findSubset (int n, ArrayList<Integer> subset) {
        // Base case :
        if (n == 0) {
            printSubset(subset);
            return;
        }


        // if it adds
        subset.add(n);
        findSubset(n-1, subset);

        // if it not add
        subset.removeLast();
        findSubset(n-1, subset);

    }
    public static void main (String [] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubset(n, subset);
    }
}
