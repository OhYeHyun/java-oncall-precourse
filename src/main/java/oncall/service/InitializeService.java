package oncall.service;

import oncall.domain.Calendar;
import oncall.domain.Month;

import java.util.List;

public class InitializeService {
    private final Calendar calendar;

    public InitializeService(Calendar calendar) {
        this.calendar = calendar;
    }

    public void initialize() {
        calendar.addMonth(new Month(1, 31, List.of(1)));
        calendar.addMonth(new Month(2, 28, List.of()));
        calendar.addMonth(new Month(3, 31, List.of(1)));
        calendar.addMonth(new Month(4, 30, List.of()));
        calendar.addMonth(new Month(5, 31, List.of(5)));
        calendar.addMonth(new Month(6, 30, List.of(6)));
        calendar.addMonth(new Month(7, 31, List.of()));
        calendar.addMonth(new Month(8, 31, List.of(15)));
        calendar.addMonth(new Month(9, 30, List.of()));
        calendar.addMonth(new Month(10, 31, List.of(3, 9)));
        calendar.addMonth(new Month(11, 30, List.of()));
        calendar.addMonth(new Month(12, 31, List.of(25)));
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
