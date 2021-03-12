package daily;

public class Interview2 {
    public int solution(String str) {
        int i = 0;
        char[] stack = new char[str.length() + 1];
        for (char ch : str.toCharArray()) {
            if (ch == stack[i]) {
                i--;
            } else {
                i++;
                stack[i] = ch;
            }
        }
        return new String(stack, 1, i).length();
    }

    public static void main(String[] args) {
        int num = new Interview2().solution("gg");
        System.out.println(num);
    }
}
