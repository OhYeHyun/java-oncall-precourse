package oncall.domain;

public class DailySchedule {
    private final Day day;
    private final String employee;

    public DailySchedule(Day day, String employee) {
        this.day = day;
        this.employee = employee;
    }

    public Day getDay() {
        return day;
    }

    public String getEmployee() {
        return employee;
    }
}
