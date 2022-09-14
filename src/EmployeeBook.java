import java.util.ArrayList;

class EmployeeBook {
    private final Employee[] employees;
    public EmployeeBook() {
        this.employees = new Employee[10];
    }

//        employeeRepository[0] = new EmployeeBook("Друг Марат Григорьевич", 5, 100_000);
//        employeeRepository[1] = new Employee("Аглеев Данил Янович", 4, 72_000);
//        employeeRepository[2] = new Employee("Баймулдина Гульнара Яновна", 2, 85_000);
//        employeeRepository[3] = new Employee("Ахметгалин Григорий Васильевич", 3, 53_000);
//        employeeRepository[4] = new Employee("Ивченкова Ангелина Вячеславовна", 1, 66_000);
//        employeeRepository[5] = new Employee("Алабин Владислав Егорович", 1, 48_000);
//        employeeRepository[6] = new Employee("Даргомыжская Антонина Никитовна", 4, 97_000);
//        employeeRepository[7] = new Employee("Голубовская Карина Григорьевна", 3, 112_000);
//        employeeRepository[8] = new Employee("Садаков Григорий Валентинович", 5, 83_000);
//        employeeRepository[9] = new Employee("Хоробритова Татьяна Маратовна", 2, 70_000);
//
//        employeeRepository.showAllData();
//        System.out.println("");
//
//        calculateSalary(employeeRepository);
//        System.out.println("Общие затраты на зарплату - " + calculateSalary(employeeRepository) + " руб.");
//        System.out.println("");
//
//        findMinSalary(employeeRepository);
//        System.out.println("");
//
//        findMaxSalary(employeeRepository);
//        System.out.println("");
//
//        calculateAverageSalary(employeeRepository);
//        System.out.println("Средняя зарплата - " + calculateAverageSalary(employeeRepository) + " руб.");
//        System.out.println("");
//
//        findAllFullNames(employeeRepository);
//        System.out.println("");
//
//        int indexPercent = 11;
//        indexSalary(employeeRepository, indexPercent);
//        System.out.println("");
//
//        int departmentNumber = 5;
//        findMinSalaryInDepartment(employeeRepository, departmentNumber);
//        findMaxSalaryInDepartment(employeeRepository, departmentNumber);
//        findTotalSalaryInDepartment(employeeRepository, departmentNumber);
//        findAverageSalaryInDepartment(employeeRepository, departmentNumber);
//        int indexPercentInDepartment = 15;
//        indexSalaryInDepartment(employeeRepository, departmentNumber, indexPercentInDepartment);
//        printEmployeesOfDepartment(employeeRepository, departmentNumber);
//        System.out.println("");
//
//        int salaryLimit = 90_000;
//        findSalaryMoreThanSalaryLimit(employeeRepository, salaryLimit);
//        findSalaryLessThanSalaryLimit(employeeRepository, salaryLimit);
//        System.out.println("");


    public void showAllData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int calculateSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getEmployeeSalary();
        }
        return sum;
    }

    public void findMinSalary(Employee[] employees) {
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

    public void findMaxSalary(Employee[] employees) {
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

    public int calculateAverageSalary(Employee[] employees) {
        return calculateSalary(employees) / employees.length;
    }

    public void findAllFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("Ф.И.О. - " + employee.getEmployeeFullName());
        }
    }

    public void indexSalary(Employee[] employees, int indexPercent) {
        int increaseSalary;
        for (int i = 0; i < employees.length; i++) {
            increaseSalary = employees[i].getEmployeeSalary() * (100 + indexPercent) / 100;
            System.out.println("Сотрудник - " + employees[i].getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
        }
    }

    public void findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
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

    public void findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
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

    public void findTotalSalaryInDepartment(Employee[] employees, int departmentNumber) {
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

    public void findAverageSalaryInDepartment(Employee[] employees, int departmentNumber) {
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

    public void indexSalaryInDepartment(Employee[] employees, int departmentNumber, int indexPercent) {
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

    public void printEmployeesOfDepartment(Employee[] employees, int departmentNumber) {
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

    public void findSalaryMoreThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() > salaryLimit) {
                System.out.println("Сотрудник, чья зарплата превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
            }
        }
    }

    public void findSalaryLessThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() <= salaryLimit) {
                System.out.println("Сотрудник, чья зарплата не превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
            }
        }
    }
}
