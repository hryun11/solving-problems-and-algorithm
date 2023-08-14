import java.util.*;

class Solution {
    int solution(int N) {
        int num = 1;

        for (int i=N; i>=1; i--) {
            num *= i;
        }

        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Solution s = new Solution();
        System.out.println(s.solution(N));
    }
}