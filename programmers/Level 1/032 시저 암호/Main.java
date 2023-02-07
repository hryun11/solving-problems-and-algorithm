class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            //공백일 경우
            if (c == ' ')
                sb.append(c);

            // 소문자일 경우
            if (Character.isLowerCase(c)) {
                // result가 z를 초과할 때
                if ((char) (c + n) > 'z') {
                    int cnt = 0;

                    while (c <= 'z') {
                        c += 1;
                        cnt++;
                    }
                    char c1 = (char) ('a' + (n-cnt));
                    sb.append(c1);
                } else { // result가 z 초과하지 않을 때
                    char c1 = (char) (c + n);
                    sb.append(c1);
                }
            }

            // 대문자일 때
            if (Character.isUpperCase(c)) {
                // result가 z를 초과할 때
                if ((char) (c + n) > 'Z') {
                    int cnt = 0;

                    while (c <= 'Z') {
                        c += 1;
                        cnt++;
                    }
                    char c1 = (char) ('A' + (n-cnt));
                    sb.append(c1);
                } else { // result가 z 초과하지 않을 때
                    char c1 = (char) (c + n);
                    sb.append(c1);
                }
            }
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((s.solution("AB", 1)));
    }
}