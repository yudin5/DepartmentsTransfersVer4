import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    private String name;
    private BigDecimal salary;

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
