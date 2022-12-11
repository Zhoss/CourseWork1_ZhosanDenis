import org.apache.commons.lang3.StringUtils;
public class Employee {
    private String employeeFullName;
    private int departmentNumber;
    private int employeeSalary;
    private int id;
    public static int employeeCounter = 1;

    public Employee(String employeeFullName, int departmentNumber, int employeeSalary) {
        try {
            setEmployeeFullName(employeeFullName);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        this.departmentNumber = departmentNumber;
        if (departmentNumber < 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Номера отделов могут быть 1-5");
        }
        this.employeeSalary = employeeSalary;
        this.id = employeeCounter;
        employeeCounter++;
    }

    public String checkFullName(String fullName) {
        String[] strings = StringUtils.split(fullName);
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            String str = StringUtils.capitalize(string);
            builder.append(str).append(" ");
        }
        return StringUtils.stripEnd(builder.toString(), null);
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

    private void setEmployeeFullName(String employeeFullName) throws BadRequestException {
        if (!StringUtils.isEmpty(employeeFullName) && !StringUtils.isBlank(employeeFullName)) {
            this.employeeFullName = checkFullName(employeeFullName);
        } else {
            throw new BadRequestException("400 Bad Request");
        }
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
