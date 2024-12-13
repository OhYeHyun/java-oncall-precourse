package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class DayOfWeek {
    private List<String> dayOfWeek = new ArrayList<>();
    private String start;

    public DayOfWeek() {
        initialize();
    }

    private void initialize() {
        dayOfWeek = List.of("월", "화", "수", "목", "금", "토", "일");
    }

    public void setStart(String startDayOfWeek) {
        start = startDayOfWeek;
    }

    public String getDayOfWeek(int day) {
        int startIndex = dayOfWeek.indexOf(start);
        int targetIndex = (startIndex + day - 1) % 7;

        return dayOfWeek.get(targetIndex);
    }
}
