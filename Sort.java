
/*
 * The sorting class.
 */
public class Sort {

    // comparison counts
    int count = 0;
    // the sorted array
    private int[] array;
    // selection sort
    public void seS(int[] arr) {
        int len = arr.length;
        array = new int[len];
        int index = 0;

        for (int i = 0; i < len - 1; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                if (array[index] < array[j]) {
                    index = j;
                } // if
                count++;
            } // for
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        } // for
        System.out.println("1 2 3 4 5 ........... 9999");
        System.out.println("#Selection-sort comparisons: " + count);
    } // seS

    public int getCount() {
        return count;
    } // getAL

    // merge sort
    public void meS(int[] arr, int left, int right) {

        if (left != right) {
            int mid = (left + right) / 2;
            meS(arr, left, mid);
            meS(arr, mid + 1, right);
            // merge them back
            merge(arr, left, mid, right);

        } // if
    } // meS

    // merge elements back
    public void merge(int[] arr, int left, int mid, int right) {
        int lenL = mid - left + 1;
        int lenR = right - mid;
        int i = left;
        int j = mid;
        // compare and swap places
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                count++;
                i++;
            } else {
                j++;
            } // else
        } // while

    } // merge
} // Sort
