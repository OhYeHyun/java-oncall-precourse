package oncall.validator;

import java.util.Objects;

public class FormatValidator {

    public static void validateDate(String dateInput) {
        validateMonthNumeric(dateInput);
        validateMonthRange(dateInput);
        validateDayOfWeek(dateInput);
    }

    private static void validateMonthNumeric(String dateInput) {
        try {
            String month = dateInput.split(",", -1)[0];
            Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 월은 숫자로 입력해 주세요.");
        }
    }

    private static void validateMonthRange(String dateInput) {
        String month = dateInput.split(",", -1)[0];
        int monthNumber = Integer.parseInt(month);
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("[ERROR] 월은 1 ~ 12 사이야 합니다.");
        }
    }

    private static void validateDayOfWeek(String dateInput) {
        String dayOfWeek = dateInput.split(",", -1)[1];
        if (!Objects.equals(dayOfWeek, "월") && !Objects.equals(dayOfWeek, "화") && !Objects.equals(dayOfWeek, "수") && !Objects.equals(dayOfWeek, "목") && !Objects.equals(dayOfWeek, "금") && !Objects.equals(dayOfWeek, "토") && !Objects.equals(dayOfWeek, "일")) {
            throw new IllegalArgumentException("[ERROR] 요일은 월화수목금토일 중 하나여야 합니다.");
        }
    }

    public static void validateEmployees(String employeesInput) {
        validateEmployeesLength(employeesInput);
        validateNumberOfEmployees(employeesInput);
    }

    private static void validateEmployeesLength(String employeesInput) {
        for (String employee : employeesInput.split(",", -1)) {
            if (employee.isEmpty() || employee.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 사원 이름은 1글자 ~ 5글자여야 합니다.");
            }
        }
    }

    private static void validateNumberOfEmployees(String employeesInput) {
        int size = employeesInput.split(",", -1).length;
        if (size < 5 || size > 35) {
            throw new IllegalArgumentException("[ERROR] 사원은 5명 ~ 35명이어야 합니다.");
        }
    }
}
