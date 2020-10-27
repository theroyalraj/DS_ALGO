// https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        /*
         * maintain 3 pointer which will store the location upto where 0 1 and 2 are
         * placed. Alternate soln (O(n)) is to count number of 0,1 and 2 and refill the
         * array but it requires two passes i.e. count sort
         */
        int n = nums.length;
        int l = 0, h = n - 1, m = 0;
        while (m >= l && m <= h) {
            if (nums[m] == 0) {
                swap(nums, l++, m++);
            } else if (nums[m] == 1)
                m++;
            else {
                swap(nums, h--, m);
            }
        }

    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}