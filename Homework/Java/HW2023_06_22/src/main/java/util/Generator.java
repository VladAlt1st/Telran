package util;

import com.github.javafaker.Faker;
import dto.Employee;
import enums.Department;
import enums.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static List<Employee> generateEmployees(int n) {
        List<Employee> employees = new ArrayList<>();
        Faker faker = new Faker();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            String name = faker.name().firstName();

            Department[] departments = Department.values();
            Department department = departments[r.nextInt(departments.length)];

            Position[] positions = Position.values();
            Position position = positions[r.nextInt(positions.length)];

            double salary = faker.number().numberBetween(100, 2000);

            employees.add(new Employee(name, department, position, salary));
        }
        return employees;
    }
}
