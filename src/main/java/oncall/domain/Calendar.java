package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final List<Month> calender = new ArrayList<>();

    public void addMonth(Month month) {
        calender.add(month);
    }

    public Month getMonth(int month) {
        return calender.stream()
                .filter(targetMonth -> targetMonth.getMonth() == month)
                .findAny()
                .get();
    }
}
