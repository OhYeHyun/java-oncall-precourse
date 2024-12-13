package oncall.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EmployeesQueue {
    private final List<String> employees;
    private int position = 0;

    public EmployeesQueue(List<String> employees) {
        this.employees = employees;
    }

    public boolean isMatch(String targetEmployee) {
        return Objects.equals(targetEmployee, employees.get(position));
    }

    public void switchEmployee() {
        Collections.swap(employees, position, (position + 1) % employees.size());
    }

    public void addPosition() {
        position = (position + 1) % employees.size();
    }

    public String curEmployee() {
        return employees.get(position);
    }

    public List<String> getEmployees() {
        return employees;
    }
}
