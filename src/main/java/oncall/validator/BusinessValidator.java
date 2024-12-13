package oncall.validator;

import java.util.HashSet;
import java.util.List;

public class BusinessValidator {

    public void validateEmployees(List<String> weekdaysEmployees, List<String> weekendEmployees) {
        validateEmployeesIsDuplicate(weekdaysEmployees, weekendEmployees);
        validateNumberEmployees(weekdaysEmployees, weekendEmployees);
    }

    private void validateEmployeesIsDuplicate(List<String> weekdaysEmployees, List<String> weekendEmployees) {
        if (weekdaysEmployees.size() != (new HashSet<>(weekdaysEmployees)).size() || weekendEmployees.size() != (new HashSet<>(weekendEmployees)).size()) {
            throw new IllegalArgumentException("[ERROR] 사원은 중복되지 않아야 합니다.");
        }
    }
    private void validateNumberEmployees(List<String> weekdaysEmployees, List<String> weekendEmployees) {
        for (String weekdaysEmployee : weekdaysEmployees) {
            if (!weekendEmployees.contains(weekdaysEmployee)) {
                throw new IllegalArgumentException("[ERROR] 평일 근무 사원과 주말 근무 사원이 일치하지 않습니다.");
            }
        }
    }

}
