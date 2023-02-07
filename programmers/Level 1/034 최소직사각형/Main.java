import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }

    public int solution2(int[][] sizes) {
        // 세로가 가로보다 큰 배열있는지 확인
        for (int k = 0; k < sizes.length; k++) {
            if (sizes[k][1] > sizes[k][0]) {
                int wide = sizes[k][0];
                int height = sizes[k][1];
                sizes[k][0] = height;
                sizes[k][1] = wide;
            }
        }
        ArrayList<Integer> wide = new ArrayList<>();
        ArrayList<Integer> height = new ArrayList<>();

        for (int l = 0; l < sizes.length; l++) {
            wide.add(sizes[l][0]);
            height.add(sizes[l][1]);
        }
        Integer[] wide2 = wide.toArray(new Integer[0]);
        Integer[] height2 = height.toArray(new Integer[0]);

        Arrays.sort(wide2);
        Arrays.sort(height2);

        int wide3 = Integer.parseInt(String.valueOf(wide2[wide2.length - 1]), 10);
        int height3 = Integer.parseInt(String.valueOf(height2[height2.length - 1]), 10);

        return wide3 * height3;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((s.solution2(new int[][]{{14,4}, {19,6}, {6,16}, {18, 7}, {7,11}})));
    }
}