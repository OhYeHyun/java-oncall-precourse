package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EmployeesQueue {
    private final List<String> employees;
    private List<String> copyEmployees;
    private int position = 0;

    public EmployeesQueue(List<String> employees) {
        this.employees = employees;
        reset();
    }

    public boolean isMatch(String targetEmployee) {
        return Objects.equals(targetEmployee, copyEmployees.get(position));
    }

    public boolean isLast() {
        return position == 0;
    }

    public void reset() {
        copyEmployees = new ArrayList<>(employees);
    }

    public void switchEmployee() {
        Collections.swap(copyEmployees, position, (position + 1) % employees.size());
    }

    public void addPosition() {
        position = (position + 1) % employees.size();
    }

    public String curEmployee() {
        return copyEmployees.get(position);
    }

    public List<String> getEmployees() {
        return employees;
    }
}
