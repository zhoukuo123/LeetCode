package 数学;

/**
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class _326_3的幂 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 是 3的19次方
        return n > 0 && 1162261467 % n == 0;
    }

    // 循环迭代
    public boolean isPowerOfThree2(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
