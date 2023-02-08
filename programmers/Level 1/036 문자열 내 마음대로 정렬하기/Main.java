import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] newStrs = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            char c = strings[i].charAt(n);
            String s = c + "";
            String newElement = s + strings[i];

            newStrs[i] = newElement;
        }
        Arrays.sort(newStrs);

        for (int j = 0; j < newStrs.length; j++) {
            String[] split = newStrs[j].split("");
            StringBuilder sb = new StringBuilder();
            int k = 1;

            while (sb.length() < (split.length - 1)) {
                sb.append(split[k]);
                k++;
            }
            arrayList.add(sb.toString());
        }
        return arrayList.toArray(new String[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((Arrays.toString(s.solution(new String[]{"sun", "bed", "car"}, 1))));
    }
}