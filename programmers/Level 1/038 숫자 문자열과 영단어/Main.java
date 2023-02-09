import java.util.Arrays;

class Solution {
    public int solution(String s) {
        String[] words = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };

        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], (i+""));
        }
        return Integer.parseInt(s);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("one4sevenseveneight"));
    }
}