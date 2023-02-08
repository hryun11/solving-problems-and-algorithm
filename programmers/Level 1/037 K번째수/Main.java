import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int beginIndex = commands[l][0] - 1;
            int endIndex = commands[l][1] - 1;

            // 1. i부터 j번째까지 배열 자르기
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int n = beginIndex; n <= endIndex; n++) {
                arrayList.add(array[n]);
            }
            // 2. 정렬
            Collections.sort(arrayList);
            // 3. 배열의 k번째 숫자
            int k = arrayList.get(commands[l][2] - 1);
            answer[l] = k;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((Arrays.toString(s.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3},{4, 4, 1},{1, 7, 3}}))));
    }
}