import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 센서의 개수
        int k = Integer.parseInt(br.readLine()); // 집중국 개수

        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 좌표 배열 오름차순으로 정렬
        Arrays.sort(nArr);

        // 각 센서 사이의 거리 배열
        int[] distance = new int[n - 1];
        for (int i=0; i<n-1; i++) {
            distance[i] = nArr[i + 1] - nArr[i];
        }
        Arrays.sort(distance);

        // 마지막 원소인 가장 먼거리 k-1가지 제외하고 원소들의 합
        int sum = 0;
        for (int i=0; i< distance.length-(k-1); i++) {
            sum += distance[i];
        }

        System.out.println(sum);
    }
}
