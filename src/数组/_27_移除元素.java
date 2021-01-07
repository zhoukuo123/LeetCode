package 数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        int count = 0;
        while (right != nums.length) {
            if (nums[right] != val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                count++;
            }
            right++;
        }
        return count;
    }
}
