package oncall.domain;

public class Day {
    private final int day;
    private final String dayOfWeek;
    private final boolean isHoliday;

    public Day(int day, String dayOfWeek, boolean isHoliday) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean getIsHoliday() {
        return isHoliday;
    }
}
