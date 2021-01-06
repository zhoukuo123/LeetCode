package 数组;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_移动零 {
    // 双指针 O(n)
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
