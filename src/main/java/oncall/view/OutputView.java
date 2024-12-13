package oncall.view;

import oncall.domain.DailySchedule;
import oncall.domain.Month;

import java.util.List;
import java.util.Objects;

public class OutputView {

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printWithLineSpace(String text) {
        print(System.lineSeparator());
        println(text);
    }

    public static void promptGetDateInput() {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public static void promptGetWeekdaysEmployeesInput() {
        print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void promptGetWeekendEmployeesInput() {
        print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void displayResult(Month month, List<DailySchedule> schedules) {
        for (DailySchedule schedule : schedules) {
            String dayOfWeek = schedule.getDay().getDayOfWeek();
            if (schedule.getDay().getIsHoliday() && !Objects.equals(schedule.getDay().getDayOfWeek(), "토") && !Objects.equals(schedule.getDay().getDayOfWeek(), "")) {
                dayOfWeek += "(휴일)";
            }
            String format = String.format("%d월 %d일 %s %s", month.getMonth(), schedule.getDay().getDay(), dayOfWeek, schedule.getEmployee());

            if (schedule.getDay().getDay() == 1) {
                printWithLineSpace(format);
            }
            if (schedule.getDay().getDay() != 1) {
                println(format);
            }
        }
    }
}
