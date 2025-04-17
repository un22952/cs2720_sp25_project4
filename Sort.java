import java.util.Random;

/*
 * The sorting class.
 */
public class Sort {

    // comparison counts
    private int count = 0;
    // array
    private int[] array;

    // selection sort
    public void seS(int[] arr) {
        int len = arr.length;
        array = new int[len];
        int index = 0;

        for (int i = 0; i < len - 1; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[index] < arr[j]) {
                    //count++;
                    index = j;
                } // if
                count++;
            } // for
            swap(arr, i, index);
        } // for
        printR(arr);
        System.out.println("1 2 3 4 5 ........... 9999");
        System.out.println("#Selection-sort comparisons: " + count);
    } // seS

    public void printR(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        } // for
        System.out.println(" ");
    } // printF

    // swap function
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } // swap

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
    private void merge(int[] arr, int left, int mid, int right) {
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

    // quick sort with left pivot
    public void quickSL(int[] arr, int left, int right) {
        int len = arr.length;
        if (left < right) {
            int l = left;
            int r = right + 1;
            count++; // counts for left and right when scanning
            while (l < r) {
                l += 1;
                r--;
                // skip the smaller value on the left side
                while (l <= r && arr[left] > arr[l]) {
                    l++;
                    count++; // counts for arr[l] and pivot
                } // while

                // skip the greater value on the right
                while (r >= l && arr[left] < arr[r]) {
                    r--;
                    count++; // counts for arr[r] and pivot
                } // while
                // swap
                if (l == len) {
                    l--;
                } // if
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            } // while
            // undo the extra swap
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // swap the pivot
            temp = arr[r];
            arr[r] = arr[left];
            arr[left] = temp;
            quickSL(arr, left, r - 1);
            quickSL(arr, r + 1, right);

        } // if
    } // quickSL

    // quick sort with right pivot
    public void quickSR(int[] arr, int left, int right) {
        if (left < right) {
            Random rand = new Random();
            int pivot = rand.nextInt(right - left + 1);// get the random pivot index

            int l = left - 1;
            int r = right + 1;
            count++; // counts for left and right when scanning
            while (l < r) {
                l++;
                r--;
                // skip the smaller values on the left side
                while (l <= r && arr[l] < arr[pivot]) {
                    l++;
                    count++; // counts for arr[l] and pivot
                } // while

                // skip the greater value on the right side
                while (l <= r && arr[r] >= arr[pivot]) {
                    r--;
                    count++; // counts for arr[r] and pivot
                } // while
                // swap
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            } // while
            // undo the swap
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // swap the pivot
            temp = arr[l];
            arr[l] = arr[pivot];
            arr[pivot] = temp;
            quickSR(arr, left, l - 1);
            quickSR(arr, l + 1, right);
        } // if
    } // quickRL

    // heap sort
    public void heapS(int[] arr) {
        int len = arr.length;
        // sort the array in max heap way
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapB(arr, len, i);
        } // for

        // sort the array in the descending order
        for (int i = len - 1; i >= 0; i--) {
            // swap larger values to the end
            int tem = arr[0];
            arr[0] = arr[i];
            arr[i] = tem;
            // reshape the tree
            heapB(arr, i, 0);
        } // for
    } // heapS

    // build the min heap
    public void heapB(int[] arr, int len, int i) {
        int rootTemp = i;
        int l = 2 * i + 1;
        int r = l + 1;

        // if left child is larger than root
        if (l < len && arr[l] > arr[rootTemp]) {
            rootTemp = l;
            count++;
        } // if
        // if right child is larger than root
        if (r < len && arr[r] > arr[rootTemp]) {
            rootTemp = r;
            count++;
        } // if
        // bubble the larger value up
        if (rootTemp != i) {
            int tem = arr[i];
            arr[i] = arr[rootTemp];
            arr[rootTemp] = tem;
            heapB(arr, len, rootTemp); // recursively call it
        } // if

    } // heapB

} // Sort
