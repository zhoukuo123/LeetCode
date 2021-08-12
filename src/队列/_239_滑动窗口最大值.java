package 队列;

/**
 * @author CoderZk
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return null;
        }
        if (k == 1) {
            return nums;
        }

        int[] maxes = new int[nums.length - k + 1];

        return maxes;
    }
}
