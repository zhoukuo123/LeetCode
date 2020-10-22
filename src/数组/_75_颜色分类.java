package 数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 也叫荷兰国旗问题, 因为红白蓝像荷兰国旗
 *
 * @author CoderZk
 * @date 2020/10/21 下午8:54
 */
public class _75_颜色分类 {
    /**
     * 一个只包含0, 1, 2的整型数组, 要求对它进行原地排序
     * 你能想出一个仅使用常数空间的一趟扫描算法吗?
     * <p>
     * 时间复杂度O(n), 空间复杂度O(1)
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            int v = nums[i];
            if (v == 0) {
                swap(nums, i++, l++);
            } else if (v == 1) {
                i++;
            } else {
                swap(nums, i, r--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
