import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        if (d.length == 1) {
            if (d[0] > budget)
                return 0;
            else return 1;
        }
        if (Arrays.stream(d).sum() < budget)
            return d.length;

        int[] clone = d.clone();
        Arrays.sort(clone);
        int i;

        for (i=0; i < clone.length; i++) {
            answer += clone[i];

            if (answer >= budget)
                break;
            if (answer + clone[i + 1] > budget)
                break;
        }
        return i+1;
    }

    public int solution2(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];

            if (budget < 0) break;

            answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((s.solution(new int[]{1,2,3,4,5}, 20)));
    }
}