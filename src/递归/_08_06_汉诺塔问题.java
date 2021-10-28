package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CoderZk
 */
public class _08_06_汉诺塔问题 {
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        int n = A.size();

        hanota(n, A, B, C);
        List<Integer> list = new ArrayList<>();
        list.addAll(C);
        for (int i = n - 1; i >= 0; i--) {
            C.add(list.get(i));
        }
    }

    /**
     * 将 n 个碟子, 从 p1 挪动到 p3
     *
     * @param p2 中间的柱子
     *           <p>
     *           时间复杂度T(n) = T(n - 1) + T(n - 1) + 1 = 2^n
     */
    public static void hanota(int n, List<Integer> p1, List<Integer> p2, List<Integer> p3) {

        if (n == 1) {
            p3.add(p1.get(0));
            p1.remove(0);
            return;
        }

        hanota(n - 1, p1, p3, p2);

        p3.add(p1.get(0));
        p1.remove(p1.size() - 1);

        hanota(n - 1, p2, p1, p3);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(0);

        hanota(list1, list2, list3);
    }
}
