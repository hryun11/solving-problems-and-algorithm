class Solution {
    public int solution(int[] number) {
        int cnt = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if ((number[i] + number[j] + number[k]) == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((s.solution(new int[]{-1, 1, -1, 1})));
    }
}