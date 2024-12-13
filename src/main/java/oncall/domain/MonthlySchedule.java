package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthlySchedule {
    private final List<DailySchedule> schedules = new ArrayList<>();

    public void addDailySchedule(DailySchedule dailySchedule) {
        schedules.add(dailySchedule);
    }

    public List<DailySchedule> getSchedules() {
        return Collections.unmodifiableList(schedules);
    }
}
