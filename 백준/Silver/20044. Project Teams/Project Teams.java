import java.util.*;

public class Main {
    public static void main(String[] args) {
        int teamNum; // 팀 수
        Scanner sc = new Scanner(System.in);
        teamNum = sc.nextInt();
        int score[] = new int[teamNum * 2]; // 코딩 역량 점수
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }
        
        Arrays.sort(score); // 점수 오름차순 정렬
        
        int min = 0;
        int k = 1;

        for (int j = 0; j < teamNum; j++) {
            int teamValue = score[j]+score[teamNum*2-k];
            if (j == 0) {
                min = teamValue;
            } else if (teamValue < min) {
                min = teamValue;
            }
            k++;
        }
        
        System.out.println(min);
    }
}