import java.util.ArrayList;

class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook(Employee[] employees, int size) {
        this.employees = new Employee[size];
    }

    public static void main(String[] args) {
        Employee[] employeeRepository = new Employee[10];
        employeeRepository[0] = new Employee("Друг Марат Григорьевич", 5, 100_000);
        employeeRepository[1] = new Employee("Аглеев Данил Янович", 4, 72_000);
        employeeRepository[2] = new Employee("Баймулдина Гульнара Яновна", 2, 85_000);
        employeeRepository[3] = new Employee("Ахметгалин Григорий Васильевич", 3, 53_000);
        employeeRepository[4] = new Employee("Ивченкова Ангелина Вячеславовна", 1, 66_000);
        employeeRepository[5] = new Employee("Алабин Владислав Егорович", 1, 48_000);
        employeeRepository[6] = new Employee("Даргомыжская Антонина Никитовна", 4, 97_000);
        employeeRepository[7] = new Employee("Голубовская Карина Григорьевна", 3, 112_000);
        employeeRepository[8] = new Employee("Садаков Григорий Валентинович", 5, 83_000);
        employeeRepository[9] = new Employee("Хоробритова Татьяна Маратовна", 2, 70_000);

        EmployeeBook employeeBook = new EmployeeBook(employeeRepository, 10);

        employeeBook.showAllData(employeeRepository);
        System.out.println("");

        employeeBook.calculateSalary(employeeRepository);
        System.out.println("Общие затраты на зарплату - " + employeeBook.calculateSalary(employeeRepository) + " руб.");
        System.out.println("");

        employeeBook.findMinSalary(employeeRepository);
        System.out.println("");

        employeeBook.findMaxSalary(employeeRepository);
        System.out.println("");

        employeeBook.calculateAverageSalary(employeeRepository);
        System.out.println("Средняя зарплата - " + employeeBook.calculateAverageSalary(employeeRepository) + " руб.");
        System.out.println("");

        employeeBook.findAllFullNames(employeeRepository);
        System.out.println("");

        int indexPercent = 11;
        employeeBook.indexSalary(employeeRepository, indexPercent);
        System.out.println("");

        int departmentNumber = 5;
        employeeBook.findMinSalaryInDepartment(employeeRepository, departmentNumber);
        employeeBook.findMaxSalaryInDepartment(employeeRepository, departmentNumber);
        employeeBook.findTotalSalaryInDepartment(employeeRepository, departmentNumber);
        employeeBook.findAverageSalaryInDepartment(employeeRepository, departmentNumber);
        int indexPercentInDepartment = 15;
        employeeBook.indexSalaryInDepartment(employeeRepository, departmentNumber, indexPercentInDepartment);
        employeeBook.printEmployeesOfDepartment(employeeRepository, departmentNumber);
        System.out.println("");

        int salaryLimit = 90_000;
        employeeBook.findSalaryMoreThanSalaryLimit(employeeRepository, salaryLimit);
        employeeBook.findSalaryLessThanSalaryLimit(employeeRepository, salaryLimit);
        System.out.println("");

        employeeBook.removeEmployee("Хоробритова Татьяна Маратовна");

        employeeBook.addEmployee("Жосан Денис Сергеевич", 2, 100_000);

        employeeBook.changeEmployee(employeeRepository, "Голубовская Карина Григорьевна", 150_000, 1);
        System.out.println("");

        employeeBook.printAllEmployeesInAllDepartment(employeeRepository);
    }

    public void showAllData(Employee[] employees) {
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
        for (Employee employee : employees) {
            increaseSalary = employee.getEmployeeSalary() * (100 + indexPercent) / 100;
            System.out.println("Сотрудник - " + employee.getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
        }
    }

    public void findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        int min = tmpList.get(0).getEmployeeSalary();
        String minSalaryEmployee = tmpList.get(0).getEmployeeFullName();
        for (Employee employee : tmpList) {
            if (employee.getEmployeeSalary() <= min) {
                min = employee.getEmployeeSalary();
                minSalaryEmployee = employee.getEmployeeFullName();
            }
        }
        System.out.println("Минимальная зарплата в отделе " + departmentNumber + " - " + min + " руб. Сотрудник - " + minSalaryEmployee);

    }

    public void findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        int max = tmpList.get(0).getEmployeeSalary();
        String maxSalaryEmployee = tmpList.get(0).getEmployeeFullName();
        for (Employee employee : tmpList) {
            if (employee.getEmployeeSalary() >= max) {
                max = employee.getEmployeeSalary();
                maxSalaryEmployee = employee.getEmployeeFullName();
            }
        }
        System.out.println("Максимальная зарплата в отделе " + departmentNumber + " - " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public void findTotalSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        int sum = 0;
        for (Employee employee : tmpList) {
            sum = sum + employee.getEmployeeSalary();
        }
        System.out.println("Общие затраты на зарплату в отделе " + departmentNumber + " - " + sum + " руб.");
    }

    public void findAverageSalaryInDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        int sum = 0;
        for (Employee employee : tmpList) {
            sum = sum + employee.getEmployeeSalary();
        }
        int average = sum / tmpList.size();
        System.out.println("Средняя зарплата в отделе " + departmentNumber + " - " + average + " руб.");
    }

    public void indexSalaryInDepartment(Employee[] employees, int departmentNumber, int indexPercent) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        int increaseSalary;
        for (Employee employee : tmpList) {
            increaseSalary = employee.getEmployeeSalary() * (100 + indexPercent) / 100;
            System.out.println("Сотрудник отдела " + departmentNumber + " - " + employee.getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
        }
    }

    public void printEmployeesOfDepartment(Employee[] employees, int departmentNumber) {
        ArrayList<Employee> tmpList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                tmpList.add(employee);
            }
        }
        for (Employee employee : tmpList) {
            System.out.println("Сотрудник отдела " + departmentNumber + " - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
        }
    }

    public void findSalaryMoreThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() > salaryLimit) {
                System.out.println("Сотрудник, чья зарплата превышает установленный уровень - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
            }
        }
    }

    public void findSalaryLessThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() <= salaryLimit) {
                System.out.println("Сотрудник, чья зарплата не превышает установленный уровень - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
            }
        }
    }

    public void addEmployee(String employeeFullName, int departmentNumber, int employeeSalary) {
        if (size >= employees.length) {
            System.out.println("Список переполнен. Добавление новой записи невозможно");
        }
        Employee newEmployee = new Employee(employeeFullName, departmentNumber, employeeSalary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(String employeeFullName1) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeFullName().equals(employeeFullName1)) {
                employees[i] = null;
                if (i != employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - i);
                }
                size--;
                System.out.println("Данные о сотруднике " + employeeFullName1 + " удалены");
                return;
            }
        }
        System.out.println("Данные о сотруднике " + employeeFullName1 + " не найдены");
    }

    public void changeEmployee(Employee[] employees, String employeeFullName2, int newSalary, int newDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeFullName().equals(employeeFullName2)) {
                employees[i].setEmployeeSalary(newSalary);
                employees[i].setDepartmentNumber(newDepartment);
            }
            System.out.println("Сотрудник " + employees[i].getEmployeeFullName() + ", новая зарплата - " + employees[i].getEmployeeSalary() + ", новый отдел - " + employees[i].getDepartmentNumber());
        }
    }

    public void printAllEmployeesInAllDepartment(Employee[] employees) {
        ArrayList<String> employeesList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == 1) {
                employeesList.add(employee.getEmployeeFullName());
            }
        }
        System.out.println("Отдел 1, сотрудники: " + employeesList);
        employeesList.removeAll(employeesList);
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == 2) {
                employeesList.add(employee.getEmployeeFullName());
            }
        }
        System.out.println("Отдел 2, сотрудники: " + employeesList);
        employeesList.removeAll(employeesList);
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == 3) {
                employeesList.add(employee.getEmployeeFullName());
            }
        }
        System.out.println("Отдел 3, сотрудники: " + employeesList);
        employeesList.removeAll(employeesList);
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == 4) {
                employeesList.add(employee.getEmployeeFullName());
            }
        }
        System.out.println("Отдел 4, сотрудники: " + employeesList);
        employeesList.removeAll(employeesList);
        for (Employee employee : employees) {
            if (employee.getDepartmentNumber() == 5) {
                employeesList.add(employee.getEmployeeFullName());
            }
        }
        System.out.println("Отдел 5, сотрудники: " + employeesList);
    }
}

