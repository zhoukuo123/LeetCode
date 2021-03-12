package daily;

public class Interview1 {
    // 暴力
    public int solution(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            String str = String.valueOf(i);
            if (str.contains("4")) {
                cnt++;
            }
        }
        return num - cnt;
    }

    public static void main(String[] args) {
        int solution = new Interview1().solution(1000);
        System.out.println(solution);
    }
}
