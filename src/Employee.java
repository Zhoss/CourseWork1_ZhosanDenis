import java.util.Objects;

public class Employee {
    private String employeeFullName;
    private int departmentNumber;
    private int employeeSalary;
    private int id;
    public static int employeeCounter = 1;

    public Employee(String employeeFullName, int departmentNumber, int employeeSalary) {
        this.employeeFullName = employeeFullName;
        this.departmentNumber = departmentNumber;
        if (departmentNumber < 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Номера отделов могут быть 1-5");
        }
        this.employeeSalary = employeeSalary;
        this.id = employeeCounter;
        employeeCounter++;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public int getId() {
        return id;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Ф.И.О - " + employeeFullName + ", отдел номер " + departmentNumber + ", размер зарплаты - " + employeeSalary + ", id = " + id;
    }

}
