package oncall.service;

import oncall.domain.DailySchedule;
import oncall.domain.Day;
import oncall.domain.Month;

import java.util.List;

public class OnCall {
    private final InitializeService initializeService;
    private final CalendarService calendarService;
    private final QueueService queueService;

    public OnCall(InitializeService initializeService, CalendarService calendarService, QueueService queueService) {
        this.initializeService = initializeService;
        this.calendarService = calendarService;
        this.queueService = queueService;
    }

    public void initialize() {
        initializeService.initialize();
    }

    public void generateCalendar(int month, String dayOfWeek) {
        calendarService.generateDays(initializeService.getCalendar(), month, dayOfWeek);
    }

    public void generateEmployees(List<String> weekdaysEmployees, List<String> weekendEmployees) {
        queueService.addEmployees(weekdaysEmployees, weekendEmployees);
    }

    public void generateSchedule() {
        queueService.generateSchedule(getDays());
    }

    private List<Day> getDays() {
        return calendarService.getDays();
    }

    public Month getMonth() {
        return calendarService.getMonth();
    }

    public List<DailySchedule> getSchedule() {
        return queueService.getSchedule();
    }
}
