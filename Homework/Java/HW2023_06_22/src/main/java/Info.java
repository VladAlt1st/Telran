import dto.Employee;
import enums.Department;
import enums.Position;

import java.util.*;

/**
 *  Info
 *  - Map<Position, List<String>>
 *  - checker() - на вход сотрудника, на выходе String в зависимости от Position
 *  - avgSalaryDep() - на вход Set<Employee>, Department, на выход средняя зп по департаменту
 *  - maxSalary() - на вход Set<Employee>, Department, на выход max зп по департаменту + у кого такая зп(имя)
 *  - minSalary() - на вход Set<Employee>, Department, на выход min зп по департаменту + у кого такая зп(имя)
 *  - getPromotion() - на вход сотрудника, в методе - засетить переход на одну позицию выше и зп на 25% больше.
 */
public class Info {
    private static final Map<Position, List<String>> info = Map.of(
            Position.JUNIOR, List.of("Some info for JUNIORS."),
            Position.MIDDLE, List.of("Some info for MIDDLES."),
            Position.SENIOR, List.of("Some info for SENIORS.")
    );

    public static String check(Employee employee) {
        if (employee == null) throw  new NullPointerException("Employee is null.");
        return info.get(employee.getPosition()).toString();
    }

    public static double avgSalaryDep(Set<Employee> employees, Department department) {
        if (employees == null) throw new NullPointerException("Employees is null.");
        if (department == null) throw new NullPointerException("Department is null.");

        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow();
    }

    public static String maxSalary(Set<Employee> employees, Department department) {
        if (employees == null) throw new NullPointerException("Employees is null.");
        if (department == null) throw new NullPointerException("Department is null.");

        Employee maxSalaryEmp = employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
        return String.format("%s: %s - %f", department, maxSalaryEmp.getName(), maxSalaryEmp.getSalary());
    }

    public static String minSalary(Set<Employee> employees, Department department) {
        if (employees == null) throw new NullPointerException("Employees is null.");
        if (department == null) throw new NullPointerException("Department is null.");

        Employee minSalaryEmp = employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
        return String.format("%s: %s - %f", department, minSalaryEmp.getName(), minSalaryEmp.getSalary());
    }

    public static boolean getPromotion(Employee employee) {
        if (employee == null) throw  new NullPointerException("Employee is null.");

        if (employee.getPosition().hasNext()) {
            employee.setPosition(employee.getPosition().next());
            employee.setSalary(employee.getSalary() * 1.25);
            return true;
        }
        return false;
    }
}
