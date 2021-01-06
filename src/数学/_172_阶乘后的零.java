package 数学;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class _172_阶乘后的零 {
    // 问题转化为：n! 最多可以分解出多少个因子 5？
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

    // 真去计算阶乘, 太慢了, 阶乘增长可是比指数增长都恐怖
    public int trailingZeroes2(int n) {
        // 计算 n!
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        // 计算有多少个0在末尾
        int zeroCount = 0;

        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }

        return zeroCount;
    }
}
