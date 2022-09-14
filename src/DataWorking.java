import java.util.ArrayList;

public class DataWorking {
    public static void showAllData(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int calculateSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getEmployeeSalary();
        }
        return sum;
    }

    public static void findMinSalary(Employee[] employees) {
        int min = employees[0].getEmployeeSalary();
        String minSalaryEmployee = employees[0].getEmployeeFullName();
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() < min) {
                min = employee.getEmployeeSalary();
                minSalaryEmployee = employee.getEmployeeFullName();
            }
        }
        System.out.println("Минимальная зарплата: " + min + " руб. Сотрудник - " + minSalaryEmployee);
    }

    public static void findMaxSalary(Employee[] employees) {
        int max = employees[0].getEmployeeSalary();
        String maxSalaryEmployee = employees[0].getEmployeeFullName();
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() > max) {
                max = employee.getEmployeeSalary();
                maxSalaryEmployee = employee.getEmployeeFullName();
            }
        }
        System.out.println("Максимальная зарплата: " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public static int calculateAverageSalary(Employee[] employees) {
        return calculateSalary(employees) / employees.length;
    }

    public static void findAllFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("Ф.И.О. - " + employee.getEmployeeFullName());
        }
    }

    public static void indexSalary(Employee[] employees, int indexPercent) {
        int increaseSalary;
        for (int i = 0; i < employees.length; i++) {
            increaseSalary = employees[i].getEmployeeSalary() * (100 + indexPercent) / 100;
            System.out.println("Сотрудник - " + employees[i].getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
        }
    }

    public static void findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        int min = tmpList.get(0).getEmployeeSalary();
        String minSalaryEmployee = tmpList.get(0).getEmployeeFullName();
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            if (tmpList.get(i1).getEmployeeSalary() <= min) {
                min = tmpList.get(i1).getEmployeeSalary();
                minSalaryEmployee = tmpList.get(i1).getEmployeeFullName();
            }
        }
        System.out.println("Минимальная зарплата в отделе " + departmentNumber + " - " + min + " руб. Сотрудник - " + minSalaryEmployee);

    }

    public static void findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        int max = tmpList.get(0).getEmployeeSalary();
        String maxSalaryEmployee = tmpList.get(0).getEmployeeFullName();
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            if (tmpList.get(i1).getEmployeeSalary() >= max) {
                max = tmpList.get(i1).getEmployeeSalary();
                maxSalaryEmployee = tmpList.get(i1).getEmployeeFullName();
            }
        }
        System.out.println("Максимальная зарплата в отделе " + departmentNumber + " - " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public static void findTotalSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        int sum = 0;
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            sum = sum + tmpList.get(i1).getEmployeeSalary();
        }
        System.out.println("Общие затраты на зарплату в отделе " + departmentNumber + " - " + sum + " руб.");
    }

    public static void findAverageSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        int sum = 0;
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            sum = sum + tmpList.get(i1).getEmployeeSalary();
        }
        int average = sum / tmpList.size();
        System.out.println("Средняя зарплата в отделе " + departmentNumber + " - " + average + " руб.");
    }

    public static void indexSalaryInDepartment(Employee[] employees, int departmentNumber, int indexPercent) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        int increaseSalary;
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            increaseSalary = tmpList.get(i1).getEmployeeSalary() * (100 + indexPercent) / 100;
            System.out.println("Сотрудник отдела " + departmentNumber + " - " + tmpList.get(i1).getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
        }
    }

    public static void printEmployeesOfDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                tmpList.add(employees[i]);
            }
        }
        for (int i1 = 0; i1 < tmpList.size(); i1++) {
            System.out.println("Сотрудник отдела " + departmentNumber + " - " + tmpList.get(i1).getEmployeeFullName() + ", размер зарплаты - " + tmpList.get(i1).getEmployeeSalary() + ", id = " + tmpList.get(i1).getId());
        }
    }

    public static void findSalaryMoreThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() > salaryLimit) {
                System.out.println("Сотрудник, чья зарплата превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
            }
        }
    }

    public static void findSalaryLessThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() <= salaryLimit) {
                System.out.println("Сотрудник, чья зарплата не превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
            }
        }
    }
}
