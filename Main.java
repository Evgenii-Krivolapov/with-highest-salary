import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.JANUARY;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        Calendar calendar = Calendar.getInstance();

        return staff.stream()
                .filter((obj) -> {
                    calendar.setTime(obj.getWorkStart());
                    return calendar.get(Calendar.YEAR) == year;
                })
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
    }
}