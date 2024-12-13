package oncall.service;

import oncall.domain.DailySchedule;
import oncall.domain.Day;
import oncall.domain.EmployeesQueue;
import oncall.domain.MonthlySchedule;

import java.util.List;

public class QueueService {
    private final MonthlySchedule monthlySchedule;
    private EmployeesQueue weekdaysQueue;
    private EmployeesQueue weekendQueue;

    public QueueService(MonthlySchedule monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
    }

    public void addEmployees(List<String> weekdaysEmployees, List<String> weekendEmployees) {
        weekdaysQueue = new EmployeesQueue(weekdaysEmployees);
        weekendQueue = new EmployeesQueue(weekendEmployees);
    }

    public void generateSchedule(List<Day> days) {
        String previousName = "";
        for (Day day : days) {
            if (day.getIsHoliday()) {
                previousName = generateDailySchedule(previousName, weekendQueue, day);
            }
            if (!day.getIsHoliday()) {
                previousName = generateDailySchedule(previousName, weekdaysQueue, day);
            }
        }
    }

    private String generateDailySchedule(String previousName, EmployeesQueue queue, Day day) {
        if (queue.isLast()) {
            queue.reset();
        }

        if (queue.isMatch(previousName)) {
            queue.switchEmployee();
        }
        String name = queue.curEmployee();
        queue.addPosition();
        monthlySchedule.addDailySchedule(new DailySchedule(day, name));

        return name;
    }

    public List<DailySchedule> getSchedule() {
        return monthlySchedule.getSchedules();
    }
}
