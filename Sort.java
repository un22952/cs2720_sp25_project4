import java.util.Random;

/*
 * The sorting class.
 */
public class Sort {

    // comparison counts
    private long count = 0;
    // array
    public int[] array;

    // sort object
    public Sort(int[] arr) {
        int len = arr.length;
        array = new int[len];
        copyR(arr);
    } // object class

    public void copyR(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            array[i] = arr[i];
        } // for

    } // copyR

    // selection sort
    public void seS(int[] arr) {
        int len = arr.length;
        array = new int[len];
        int index = 0;

        for (int i = 0; i < len - 1; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[index] < arr[j]) {

                    index = j;
                } // if
                count++; // runs n^2 times
            } // for
            swap(arr, i, index);
        } // for
        printR(arr);

        System.out.println("#Selection-sort comparisons: " + count);
    } // seS

    // print in reverse
    public void printR(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        } // for
        System.out.println(" ");
    } // printF

    // print forward
    public void printF(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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

    public long getCount() {
        return count;
    } // getAL

    // merge sort
    public void meS(int[] arr, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            meS(array, left, mid);
            meS(array, mid + 1, right);
            // merge them back
            merge(array, left, mid, right);

        } // if
    } // meS

    // merge elements back
    private void merge(int[] arr, int left, int mid, int right) {
        int lenL = mid - left + 1;
        int lenR = right - mid;

        // create temp arrays
        int[] L = new int[lenL];
        int[] R = new int[lenR];

        // copy arrays
        for (int i = 0; i < lenL; i++) L[i] = arr[left + i];
        for (int j = 0; j < lenR; j++) R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int l = left;
        // compare and swap places
        while (i < lenL && j < lenR) {
            count++; // runs nlogn times
            // compare to add to array
            if (L[i] <= R[j]) {

                arr[l] = L[i];
                i++;
            } else {
                arr[l] = R[j];
                j++;
            } // else
            l++;
        } // while
        // copy the remianing ones to array
        while (i < lenL) {
            arr[l] = L[i];
            i++;
            l++;
        } // while
        while (j < lenR) {
            arr[l] = R[j];
            j++;
            l++;
        } // while

    } // merge

    // Quick sort with first element as pivot
    public void quickSL(int[] arr, int left, int right) {
        quickL(array, left, right);
    } // quickSL
    // quick sort with left pivot
    public void quickL(int[] arr, int left, int right) {
        int len = arr.length;

        if (left < right) {
            int l = left;
            int r = right + 1;

            while (l < r) {
                l += 1;
                r--;

                // skip the smaller value on the left side
                while (l <= r && arr[left] > arr[l]) {
                    l++;
                    count++; // counts for arr[l] and pivot.
                } // while

                // skip the greater value on the right
                while (r >= l && arr[left] < arr[r]) {
                    r--;
                    count++; // counts for arr[r] and pivot.
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
            quickL(arr, left, r - 1);
            quickL(arr, r + 1, right);

        } // if
    } // quickSL

    // Quick Sort with random pivot
    public void quickSR(int[] arr, int left, int right) {
        Random rand = new Random();
        int pivot = rand.nextInt(right - left + 1);
        double d = pivot / (left + right);
        quickR(array, left, right, d);
    } // quickSR
    // quick sort with right pivot
    public void quickR(int[] arr, int left, int right, double d) {

        if (left < right) {

            int pivot = left + (int)((double)(right - left) * d);// get the random pivot index
            //swap(arr, pivot, left);
            int l = left - 1;
            int r = right + 1;
            // compare the elements
            while (l < r) {
                l++;
                r--;
                // skip the smaller values on the left side
                while (l <= r && arr[l] <= arr[pivot]) {
                    l++;
                    count++; // counts for arr[l] and pivot. It runs n times
                } // while

                // skip the greater value on the right side
                while (l <= r && arr[r] > arr[pivot]) {
                    r--;
                    count++; // counts for arr[r] and pivot. It runs n times
                } // while
                if (l == arr.length) l--;
                // swap
                swap(arr, r, l);

            } // while
            // undo the swap
            swap(arr, r, l);

            // swap the pivot
            swap(arr, r, left);
            // recersively runs
            quickR(arr, left, r - 1, d);
            quickR(arr, r + 1, right, d);
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
        copyR(arr);
    } // heapS

    // build the min heap
    public void heapB(int[] arr, int len, int i) {
        int rootTemp = i; // root
        int l = 2 * i + 1;// left child
        int r = l + 1; // right child
        count++; // counts for comparing the root and left child
        // if left child is larger than root
        if (l < len && arr[l] > arr[rootTemp]) {
            rootTemp = l;

        } // if
        count++; // counts for comparing the root and right child
        // if right child is larger than root
        if (r < len && arr[r] > arr[rootTemp]) {
            rootTemp = r;

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
