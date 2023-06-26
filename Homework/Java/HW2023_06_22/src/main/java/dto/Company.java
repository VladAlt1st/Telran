package dto;

import enums.Department;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Company
 *  - name
 *  - Set<Employee>
 *  - Set<Department>
 */

@Getter
@EqualsAndHashCode
@ToString
public class Company {
    private final String name;
    private final Set<Employee> employees;
    private final Set<Department> departments;

    public Company(String name, List<Employee> employees) {
        this.name = name;
        this.employees = new HashSet<>(employees);
        this.departments = Set.of(Department.QA, Department.FE, Department.BE);
    }
}
