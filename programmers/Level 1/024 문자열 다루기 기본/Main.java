/*
* 문자열 다루기 기본
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
입출력 예
s	return
"a234"	false
"1234"	true
* */

class Solution {
    public boolean solution(String s) {

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            //char -> string
            String strI = Character.toString(s.charAt(i));

            for (int j=0; j<=9; j++) {
                // int -> string
                String strJ = Integer.toString(j);

                if (strI.equals(strJ)) {
                    sb.append(j);
                    break;
                }
            }
        }

        if (sb.length() == s.length()) { return true; }
        else { return false; }
    }

    public boolean solution2(String s) {
        boolean answer = true;

        if(s.length() != 4 && s.length() != 6)    // 길이가 4와 6이 아닌 경우 => false
            answer = false;
        for(int i=0; i<=s.length()-1; i++)
            if(!Character.isDigit(s.charAt(i)))   // .charAt(): string 타입의 문자열에서 i번째 문자를 char 타입 문자로 변환
                answer = false;                   // .isDigit: 숫자 판별 함수, 단일 느낌표(!) — 논리 부정 연산자
        return answer;                            // 숫자 타입이 아니라면 false
    }

    public boolean solution3(String s) {
        int length = s.length();
        if (length != 4 && length != 6)
            return false;
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("354abc"));
    }
}