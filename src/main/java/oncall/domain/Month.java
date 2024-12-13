package oncall.domain;

import java.util.Collections;
import java.util.List;

public class Month {
    private final int month;
    private final int lastDay;
    private final List<Integer> holidays;

    public Month(int month, int lastDay, List<Integer> holidays) {
        this.month = month;
        this.lastDay = lastDay;
        this.holidays = holidays;
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }

    public List<Integer> getHolidays() {
        return Collections.unmodifiableList(holidays);
    }
}
