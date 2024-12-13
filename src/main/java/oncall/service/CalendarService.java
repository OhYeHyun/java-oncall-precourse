package oncall.service;

import oncall.domain.Calendar;
import oncall.domain.Day;
import oncall.domain.DayOfWeek;
import oncall.domain.Month;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CalendarService {
    private final DayOfWeek dayOfWeek;
    private final List<Day> days = new ArrayList<>();
    private Month month;

    public CalendarService(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void generateDays(Calendar calendar, int monthName, String dayOfWeekName) {
        month = calendar.getMonth(monthName);
        dayOfWeek.setStart(dayOfWeekName);
        createDay();
    }

    private void createDay() {
        int day = 1;
        while (day <= month.getLastDay()) {
            String dayOfWeekName = dayOfWeek.getDayOfWeek(day);
            days.add(new Day(day, dayOfWeekName, isHoliday(day, dayOfWeekName)));
            day++;
        }
    }

    private boolean isHoliday(int day, String dayOfWeek) {
        return month.getHolidays().contains(day) || Objects.equals(dayOfWeek, "토") || Objects.equals(dayOfWeek, "일");
    }

    public List<Day> getDays() {
        return Collections.unmodifiableList(days);
    }

    public Month getMonth() {
        return month;
    }
}
