/*
Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.

Examples:

Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: Minimum length subarray is [4, 45, 6]
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray exist
Constraints:
1 ≤ arr.size, x ≤ 105
0 ≤ arr[] ≤ 104
*/

// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            // Try to shrink the window
            while (sum > x) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        // If no valid subarray found
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
