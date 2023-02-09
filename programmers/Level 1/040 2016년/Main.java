import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    public String solution(int a, int b) {

        LocalDate localDate = LocalDate.of(2016, a, b);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        return dayOfWeek.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.US).toUpperCase();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(1, 1));
    }
}