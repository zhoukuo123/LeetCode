package 二分;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class _69_x的平方根 {
    public int mySqrt(int x) {
        // 二分查找0~x之间 结果是满足 k^2 <= x 的最大值k
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
