package oncall;

import oncall.controller.OnCallController;
import oncall.domain.Calendar;
import oncall.domain.DayOfWeek;
import oncall.domain.MonthlySchedule;
import oncall.service.CalendarService;
import oncall.service.InitializeService;
import oncall.service.OnCall;
import oncall.service.QueueService;
import oncall.validator.BusinessValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        InitializeService initializeService = new InitializeService(calendar);

        DayOfWeek dayOfWeek = new DayOfWeek();
        CalendarService calendarService = new CalendarService(dayOfWeek);

        MonthlySchedule monthlySchedule = new MonthlySchedule();
        QueueService queueService = new QueueService(monthlySchedule);

        OnCall onCall = new OnCall(initializeService, calendarService, queueService);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BusinessValidator businessValidator = new BusinessValidator();

        OnCallController controller = new OnCallController(onCall, inputView, outputView, businessValidator);
        controller.run();
    }
}
