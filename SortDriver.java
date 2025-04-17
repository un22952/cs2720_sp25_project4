import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

/*
 * Sorting driver.
 */
public class SortDriver {

    /*
     * The main function.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read file
        try(BufferedReader reader = new BufferedReader(
                new FileReader(args[0]))) {
            String[] stF = reader.readLine().split("\\s+");
            int len = stF.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(stF[i]);
            } // for
            System.out.println("selection-sort (s)\n" + "merge-sort (m)\n" + "heap-sort (h)\n"
                               + "quick-sort-fp (q)\n" + "quick-sort-rp (r)\n"
                               + "Enter the algorithm: \n");
            Sort s = new Sort(arr);
            String input = scanner.nextLine();
            switch (input) {
            case "s":
                s.seS(arr);
                break;
            case "m":
                s.meS(arr, 0, len - 1);
                s.printF(s.array);

                System.out.println("#Merge-sort comparisons: " + s.getCount());
                break;
            case "h":
                s.heapS(arr);
                s.printF(s.array);
                System.out.println("#Heap-sort comparisons: " + s.getCount());
                break;
            case "q":
                s.quickSL(arr, 0, len - 1);

                s.printF(s.array);

                System.out.println("#Quick-sort-fp comparisons: " + s.getCount());
                break;
            case "r":
                s.quickSR(arr, 0, len - 1);
                s.printF(s.array);
                System.out.println("#Quick-sort-rp comparisons: " + s.getCount());
                break;
            default:
                System.out.println("Invalid option!");
                break;
            } // switch
        } catch (IOException e) {
            e.printStackTrace();
        } // catch
    } // main
} // SortDriver
