/*
자연수 뒤집어 배열로 만들기
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
입출력 예
n	return
12345	[5,4,3,2,1]
*/

import java.util.Arrays;

class Solution {
    public int[] solution(long n) {

        //1.
        String a = Long.toString(n);
        int[] answer = new int[a.length()];
        int cnt = 0;

        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            cnt++;
        }
        return answer;


        //2.
        String num = Long.toString(n);
        int[] answer = new int[num.length()];
        int index = 0;
        for (int i = num.length()-1; i >= 0; i--) {
            char c = num.charAt(i);
            answer[index++] += Integer.parseInt(c +"");
        }
        return answer;

        //3.
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] solution = s.solution(12345);

        System.out.println(Arrays.toString(solution));
    }
}
