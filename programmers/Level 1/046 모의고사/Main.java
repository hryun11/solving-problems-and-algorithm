/*
* 모의고사
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
* */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] students = {num1, num2, num3};

        Arrays.sort(students)

        // 최고 점수
        int highest = 0;
        // 최고 득점자 배열
        ArrayList<Integer> first = new ArrayList<>();
        first.add(0);

        int j = 0;
        //num 차례대로
        while (j <= 2) {
            int cnt = 0;
            // 찍는 패턴 배열의 길이가 정답의 배열보다 짧다면,
            ArrayList<Integer> arrayList = new ArrayList<>();

            if (students[j].length < answers.length) {
                // answers 배열 길이만큼 num 배열 반복해서 늘이기
                // Arraylist에 answers.length만큼 넣기
                int k = 0;
                while (arrayList.size() < answers.length) {
                    if (k > students[j].length - 1) { k = 0; }

                    arrayList.add(students[j][k]);
                    k++;
                }
                for (int l=0; l < answers.length; l++) {
                    if (arrayList.get(l) == answers[l]) { cnt++; }
                }
            } else {
                for (int l=0; l < answers.length; l++) {
                    if (students[j][l] == answers[l]) { cnt++; }
                }
            }
            // 수포자 j가 맞은 개수가 현재 최고득점보다 높으면, 최고득점은 cnt, first 배열은 초기화, 현재 수포자가 들어감
            if (highest < cnt) {
                highest = cnt;
                first.clear();
                first.add(0, j+1);
            } else if (highest == cnt) {
                first.add(j+1);
            }
            j++;
        }
        Integer[] integers = first.toArray(new Integer[0]);

        return Arrays.stream(integers).mapToInt(i -> i).toArray();
    }

    public int[] solution2(int[] answers) {
        int[] score = {0,0,0};
        ArrayList<Integer> maxScore = new ArrayList<Integer>();
        int[][] patterns = {{1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}};

        for(int i = 0; i < answers.length; i++) {
            System.out.println(i%5);
            System.out.println(patterns[0][i%5]);
            System.out.println("======0=======");
            System.out.println(i%8);
            System.out.println(patterns[1][i%8]);
            System.out.println("======1========");
            System.out.println(i%10);
            System.out.println(patterns[2][i%10]);
            System.out.println("======2==========");
            if (patterns[0][i%5] == answers[i]) {
                score[0]++;
            }
            if (patterns[1][i%8] == answers[i]) {
                score[1]++;
            }
            if (patterns[2][i%10] == answers[i]) {
                score[2]++;
            }
        }

        int [] sortScore = score.clone();
        Arrays.sort(sortScore);
        int max = sortScore[2];
        for(int i = 0; i < score.length; i++) {
            if(score[i]==max) {
                maxScore.add(i+1);
            }
        }

        int[] answer = new int[maxScore.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = maxScore.get(i);
        }
        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(new int[]{3,5})));
    }
}