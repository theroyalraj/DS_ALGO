// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
class solution {

    public static void merge(int m, int n, int[] arr1, int[] arr2) {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i = n - 1; i >= 0; i--) {
            /*
             * Find the smallest element greater than ar2[i]. Move all elements one position
             * ahead till the smallest greater element is not found
             */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
