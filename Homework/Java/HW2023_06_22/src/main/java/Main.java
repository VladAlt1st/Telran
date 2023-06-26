import dto.Company;
import dto.Employee;
import enums.Department;
import util.Generator;

import java.util.List;

/**
 * Создайте классы
 *  Company
 *  - name
 *  - Set<Employee>
 *  - Set<Department>
 *  Employee
 *  - name
 *  - Department(enum)
 *  - Position(enum)
 *  - double salary
 *  Info
 *  - Map<Position, List<String>>
 *  - checker() - на вход сотрудника, на выходе String в зависимости от Position
 *  - avgSalaryDep() - на вход Set<Employee>, Department, на выход средняя зп по департаменту
 *  - maxSalary() - на вход Set<Employee>, Department, на выход max зп по департаменту + у кого такая зп(имя)
 *  - minSalary() - на вход Set<Employee>, Department, на выход min зп по департаменту + у кого такая зп(имя)
 *  - getPromotion() - на вход сотрудника. в методе - засетить переход на одну позицию выше и зп на 25% больше.
 */

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Generator.generateEmployees(10);
        System.out.println(employees);

        Company company = new Company("EgorovAndCompany", employees);

        System.out.println(Info.check(employees.get(0)));
        System.out.println(Info.check(employees.get(1)));

        System.out.println(Info.maxSalary(company.getEmployees(), Department.QA));
        System.out.println(Info.minSalary(company.getEmployees(), Department.FE));
        System.out.println(Info.avgSalaryDep(company.getEmployees(), Department.BE));

        System.out.println(Info.getPromotion(employees.get(0)));
        System.out.println(employees.get(0));
        System.out.println(Info.getPromotion(employees.get(1)));
        System.out.println(employees.get(1));
    }
}
