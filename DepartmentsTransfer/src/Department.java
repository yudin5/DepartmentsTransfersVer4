import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> listOfEmployees;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getListOfEmployees() {
        if (listOfEmployees == null) {
            listOfEmployees = new ArrayList<>();
        }
        return listOfEmployees;
    }

    public void addToEmployeeList(Employee employee) {
        getListOfEmployees().add(employee);
    }

    public void removeFromEmployeeList(Employee employee) {
        getListOfEmployees().remove(employee);
    }

    public ArrayList<String> printAllEmployees() {
        ArrayList<String> composition = new ArrayList<>();
        composition.add(String.format("%-30s%-15s%-8s","ФИО","Отдел","Зарплата"));
        composition.add("-----------------------------------------------------");
        listOfEmployees = getListOfEmployees();
        for (Employee employee : listOfEmployees) {
            String line = String.format("%-30s%-15s%8s", employee.getName(), this.getName(), employee.getSalary());
            composition.add(line);
        }
        return composition;
    }

    public BigDecimal getAverageSalary() {
        BigDecimal sum = new BigDecimal(0);
        listOfEmployees = getListOfEmployees();
        for (Employee employee : listOfEmployees) {
            sum = sum.add(employee.getSalary());
        }
        if (listOfEmployees.size() != 0) {
            BigDecimal size = new BigDecimal(listOfEmployees.size());
            return sum.divide(size, 2, RoundingMode.HALF_EVEN);
        } else {
            return BigDecimal.ZERO;
        }

    }
}
