import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i< arr1.length; i++) {

            System.out.println("i = "+i);
            String toBinaryString = Long.toBinaryString(arr1[i]);
            String toBinaryString1 = Long.toBinaryString(arr2[i]);
            long arr3 = Long.parseLong(toBinaryString) +
                    Long.parseLong(toBinaryString1);

            System.out.println("arr3 = "+arr3);

            String[] ints = (arr3+"").split("");

            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(ints));

            if (ints.length != n) {
                while (arrayList.size() < n) {
                    arrayList.add(0, "0");
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int k=0; k< arrayList.size(); k++) {
                if ((arrayList.get(k)).equals("0")) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((Arrays.toString(s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))));
    }
}