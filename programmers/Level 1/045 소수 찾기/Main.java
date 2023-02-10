/*
* 소수 찾기
문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
입출력 예
n	result
10	4
5	3
입출력 예 설명
입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
* */


class Solution {
    public int solution(int n) {
        int answer = 0;


        for (int i=2; i<=n; i++) {
            if (n == 2) {
                return 1;
            }

            for (int j=2; j<=Math.sqrt(i); j++) {
                // i를 1과 i자신이 아닌 j로 나누었을 때 나누어 떨어지는 수가 있다면 소수가 아님
                if (i % j == 0) {
                    answer--;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }

    int numberOfPrime(int n) {
        int count = 0;
        int result = 0;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                if ( i % j == 0) count++;
            }
            if(count == 2) result++;
            count = 0;
        }

        return result;
    }

    public int solution3(int n) {
        int answer = 0;
        boolean[] prime = new boolean [n+1];
        for(int i=2; i<=n ; i++)
            prime[i]=true; //2~n번째수를 true로 초기화

        //제곱근 구하기
        int root=(int)Math.sqrt(n);
        for(int i=2; i<=root; i++){ //2~루트n까지 검사
            if(prime[i]==true){ //i번째의 수가 소수일 때
                for(int j=i; i*j<=n; j++) //그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문)
                    prime[i*j]=false;
            }
        }

        for(int i =2; i<=n; i++) {
            if(prime[i]==true)
                answer++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution3(567857));
    }
}