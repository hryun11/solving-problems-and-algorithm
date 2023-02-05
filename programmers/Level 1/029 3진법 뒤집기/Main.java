/*
* 3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
입출력 예 설명
입출력 예 #1

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45	1200	0021	7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125	11122	22111	229
따라서 229를 return 해야 합니다.
* */


class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int a = n;

        // 앞뒤 반전 3진법
        while (a > 0) {
            sb.append(a % 3);
            a = a/3;
        }
        long reverse = Long.parseLong(sb.toString());

        //10진수 구하기
        int l = (reverse + "").length(); // 3진법 반전 수의 길이
        int j = l-1;
        int d = 0;

        for (int i=0; i <= l-2; i++) {
            int b = (reverse + "").charAt(i) - '0';
            d += b * Math.pow(3, j);
            j--;
        }
        int end = ((reverse + "").charAt(l - 1)) - '0';

        return d + end;
    }

    public int solution2(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();
        System.out.println(a);

        return Integer.parseInt(a,3); // parseInt는 String을 특정 진수로 변환. radix로 n진수로 변환할지 정함.
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println((s.solution(125)));
    }
}