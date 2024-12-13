package oncall.domain;

import java.util.List;

public class DayOfWeek {
    private final List<String> dayOfWeek = List.of("월", "화", "수", "목", "금", "토", "일");
    private final String start;

    public DayOfWeek(String start) {
        this.start = start;
    }

    public String getDayOfWeek(int day) {
        int startIndex = dayOfWeek.indexOf(start);
        int targetIndex = (startIndex + day - 1) % 7;

        return dayOfWeek.get(targetIndex);
    }
}
