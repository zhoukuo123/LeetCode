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

    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }
}
