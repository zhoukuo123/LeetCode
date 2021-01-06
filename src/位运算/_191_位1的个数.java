package 位运算;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class _191_位1的个数 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int bits = 0;
        while (mask != 0) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /*
    位操作的小技巧: 对于任意数字 n ，将 n 和 n−1 做与运算，会把最后一个 1 的位变成 0
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }
}
