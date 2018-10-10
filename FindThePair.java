/*
 * Have a collection of numbers, where need to find if there exists a pair 
 * whose sum is equal to the input.
 */
package findthepair;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class FindThePair {
    
    private final int[] COLLECTION;
    private final int target;
    
    public FindThePair(int target) {
        this.COLLECTION = createCollection(1000);
        this.target = target;
    }

    public static void main(String[] args) {
        FindThePair fp = new FindThePair(input(""));
        
        long startTime = System.nanoTime();
        boolean solution = fp.solve();
        long estimatedTime = System.nanoTime() - startTime;
        
        System.out.println(solution);
        System.out.println(Arrays.toString(fp.COLLECTION));
        System.out.printf("%nEstimated time in microseconds: %,d%n%n",
                estimatedTime / 1000);
    }

    private static int input(String message) {
        Scanner sc = new Scanner (System.in);
        while (true) {
            System.out.print(message);
            String msg = sc.nextLine();
            try {
                return Integer.parseInt(msg);
            } catch(NumberFormatException ex) {
                System.err.println(ex.toString());
            }
        }
    }

    private boolean solve() {
        for (int i = 0, j = 1; i < COLLECTION.length - 1;) {
            int sum = COLLECTION[i] + COLLECTION[j];
            //String output = String.format("%d %d %d %d", i, j, target, sum);
            if (sum < target) {
                j++;
                //System.out.println(output);
                if (j == COLLECTION.length) {
                    j = ++i;
                    //System.out.println(output);
                }
            } else if (sum > target) {
                j = ++i;
                //System.out.println(output);
            } else {
                //System.out.println(output);
                return true;
            }
        }
        return false;
    }
    
    private int[] createCollection(int size) {
        int[] result = new int[size];
        result[0] = 1;
        for (int i = 1; i < size; i++) {
            Random r = new Random(i);
            result[i] = result[i - 1] + r.nextInt(i);
        }
        return result;
    }
}