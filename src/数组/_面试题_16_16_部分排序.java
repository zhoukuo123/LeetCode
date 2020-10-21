package 数组;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 *
 * @author CoderZk
 * @date 2020/10/21 下午9:33
 */
public class _面试题_16_16_部分排序 {
    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};
        // 从左扫描到右寻找逆序对(正序: 逐渐变大)
        int max = array[0];
        int r = -1; // 用来记录最右的那个逆序对位置
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            if (v < max) {
                r = i;
            } else {
                max = v;
            }
        }

        // 从右扫描到左寻找逆序对(正序: 逐渐变小)
        int min = array[array.length - 1];
        int l = -1; // 用来记录最左的那个逆序对位置
        for (int i = array.length - 2; i >= 0; i--) {
            int v = array[i];
            if (v > min) {
                l = i;
            } else {
                min = v;
            }
        }
        return new int[]{l, r};
    }
}
