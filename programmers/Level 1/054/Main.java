/*
* 체육복
문제 설명
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
입출력 예 설명
예제 #1
1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

예제 #2
3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
* */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = 0;
        int have = n - lost.length; // 체육복 가진 인원

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복 도난당한 학생
        for (int r : reserve) {
            for (int l : lost) {
                if (r == l) {
                    System.out.println("여벌 체육복 도난 당한 학생");
                    have++;
                    r = -1;
                    l = -1;
                    System.out.println("reserve, lost 값 -2로 변환");
                    break;
                }
            }
        }

        if (reserve.length == 0 || lost.length == 0) {
            System.out.println("reserve나 lost가 없을 때 바로 리턴");
            return have+cnt;
        }

        for (int r : reserve) {
            for (int l : lost) {
                if ((l - 1) == r) {
                    r = -1;
                    l = -1;
                    cnt++;
                }
            }
        }
        System.out.println("cnt = "+cnt);

        for (int r : reserve) {
            for (int l : lost) {
                if ((l + 1) == r) {
                    l = -1;
                    r = -1;
                    cnt++;
                }
            }
        }
        System.out.println("cnt = "+cnt);

        return have + cnt;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            System.out.println("people[l-1] = "+people[l-1]);
            people[l-1]--;
        }
        for (int r : reserve) {
            System.out.println("people[r-1] = "+people[r-1]);
            people[r-1]++;
        }
        System.out.println("people = "+Arrays.toString(people));

        return n;
    }

    public int solutionHashSet(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> loSet = new HashSet<>();

        for (int i : reserve) {
            resSet.add(i);
        }
        for (int i : lost) {
            if (resSet.contains(i)) {
                resSet.remove(i);
            } else {
                loSet.add(i);
            }
        }
        for (int i : resSet) {
            if (loSet.contains(i - 1)) {
                loSet.remove(i-1);
            } else if (loSet.contains(i+1)) {
                loSet.remove(i + 1);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution2(15, new int[]{2, 4, 6, 8,11}, new int[]{1, 3, 4, 5, 6, 7, 9,12}));
    }
}
