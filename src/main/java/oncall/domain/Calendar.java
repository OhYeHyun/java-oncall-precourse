package oncall.domain;

import java.util.Collections;
import java.util.List;

public class Calendar {
    private final Month month;
    private final List<Day> day;

    public Calendar(Month month, List<Day> day) {
        this.month = month;
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public List<Day> getDay() {
        return Collections.unmodifiableList(day);
    }
}
