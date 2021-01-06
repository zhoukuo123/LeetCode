package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class _412_FizzBuzz {
    // 模拟法 O(n)
    public List<String> fizzBuzz1(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                ans.add("Fizz");
            } else if (divisibleBy5) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }

    // 字符串连接
    public List<String> fizzBuzz2(int n) {
        List<String> ans = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            String numAnsStr = "";

            if (divisibleBy3) {
                numAnsStr += "Fizz";
            }
            if (divisibleBy5) {
                numAnsStr += "Buzz";
            }
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }

            ans.add(numAnsStr);
        }
        return ans;
    }

    // 用哈希表, 映射更灵活, 可维护性更好
    public List<String> fizzBuzz3(int n) {
        List<String> ans = new ArrayList<>();

        HashMap<Integer, String> fizzBuzzDict = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key : fizzBuzzDict.keySet()) {
                if (num % key == 0) {
                    numAnsStr += fizzBuzzDict.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }

            ans.add(numAnsStr);
        }

        return ans;
    }
}
