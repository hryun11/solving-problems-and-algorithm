import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.println(numbers[i]+numbers[j]);
                if (!arrayList.contains(numbers[i] + numbers[j])) {
                    arrayList.add(numbers[i]+numbers[j]);
                }
            }
        }
        Integer[] integers = arrayList.toArray(arrayList.toArray(new Integer[0]));
        Arrays.sort(integers);
        int[] ints = Arrays.stream(integers).mapToInt(i -> i).toArray();
        return ints;
    }

    public int[] solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>(); // hashset 자동 오름차순 정렬, 및 중복 값 덮어쓰기

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                System.out.println(numbers[i] + numbers[j]);
                set.add(numbers[i] + numbers[j]);
                System.out.println(set);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution2(new int[]{5,0,2,7})));
    }
}