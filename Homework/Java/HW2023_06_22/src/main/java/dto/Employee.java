package dto;

import enums.Department;
import enums.Position;
import lombok.*;

/**
 *  Employee
 *  - name
 *  - Department(enum)
 *  - Position(enum)
 *  - double salary
 */

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee implements Comparable<Employee> {
    private String name;
    private Department department;
    private Position position;
    private double salary;

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
