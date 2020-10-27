// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
class Solution {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] ans = new int[2];
        int a = 0, b = 0;
        for (int x : arr) {
            b = Math.abs(x) - 1;
            if (arr[b] <= 0) {
                ans[0] = b + 1;
                continue;
            }
            arr[b] = -arr[b];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                a = i + 1;
        }
        ans[1] = a;
        return ans;

    }
}