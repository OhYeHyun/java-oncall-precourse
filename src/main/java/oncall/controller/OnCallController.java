package oncall.controller;

import oncall.service.OnCall;
import oncall.validator.BusinessValidator;
import oncall.validator.FormatValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class OnCallController {
    private final OnCall onCall;
    private final InputView inputView;
    private final OutputView outputView;
    private final BusinessValidator businessValidator;

    public OnCallController(OnCall onCall, InputView inputView, OutputView outputView, BusinessValidator businessValidator) {
        this.onCall = onCall;
        this.inputView = inputView;
        this.outputView = outputView;
        this.businessValidator = businessValidator;
    }

    public void run() {
        onCall.initialize();

        String dateInput = getDateInput();
        int month = parseMonth(dateInput);
        String dayOfWeek = parseDayOfWeek(dateInput);

        onCall.generateCalendar(month, dayOfWeek);

        List<List<String>> employeesInput = getEmployeesInput();
        onCall.generateEmployees(employeesInput.get(0), employeesInput.get(1));
        onCall.generateSchedule();

        outputView.displayResult(onCall.getMonth(), onCall.getSchedule());
    }

    private String getDateInput() {
        while (true) {
            try {
                OutputView.promptGetDateInput();
                String dateInput = inputView.getInput();
                FormatValidator.validateDate(dateInput);

                return dateInput;
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private List<String> getWeekdaysEmployeesInput() {
        while (true) {
            try {
                OutputView.promptGetWeekdaysEmployeesInput();
                String employeesInput = inputView.getInput();

                FormatValidator.validateEmployees(employeesInput);
                return parseEmployees(employeesInput);
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private List<String> getWeekendEmployeesInput() {
        while (true) {
            try {
                OutputView.promptGetWeekendEmployeesInput();
                String employeesInput = inputView.getInput();
                FormatValidator.validateEmployees(employeesInput);

                return parseEmployees(employeesInput);
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private List<List<String>> getEmployeesInput() {
        while (true) {
            try {
                List<String> weekdaysEmployeesInput = getWeekdaysEmployeesInput();
                List<String> weekendEmployeesInput = getWeekendEmployeesInput();
                businessValidator.validateEmployees(weekdaysEmployeesInput, weekendEmployeesInput);

                return List.of(weekdaysEmployeesInput, weekendEmployeesInput);
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private int parseMonth(String dateInput) {
        return Integer.parseInt(dateInput.split(",", -1)[0]);
    }

    private String parseDayOfWeek(String dateInput) {
        return dateInput.split(",", -1)[1];
    }

    private List<String> parseEmployees(String employeesInput) {
        return Arrays.stream(employeesInput.split(",", -1)).toList();
    }
}
