// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int msf = 0, max = Integer.MIN_VALUE;
        for (int a : nums) {
            msf += a;
            max = Math.max(max, msf);
            msf = Math.max(msf, 0);
        }
        return max;
    }
}