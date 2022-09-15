class EmployeeBook {
    private final Employee[] employees;

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
//        employeeRepository[6] = new Employee("Даргомыжская Антонина Никитовна", 4, 97_000);
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

        employeeBook.removeEmployee(employeeRepository, "Хоробритова Татьяна Маратовна");
        System.out.println("");

        employeeBook.addEmployee(employeeRepository, "Жосан Денис Сергеевич", 1, 100_000);
        System.out.println("");

        employeeBook.changeEmployee(employeeRepository, "Голубовская Карина Григорьевна", 150_000, 1);
        System.out.println("");

        employeeBook.printAllEmployeesInDepartment(employeeRepository, 1);
    }

    public void showAllData(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public int calculateSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getEmployeeSalary();
            }
        }
        return sum;
    }

    public void findMinSalary(Employee[] employees) {
        int min = Integer.MAX_VALUE;
        String minSalaryEmployee = "";
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getEmployeeSalary() < min) {
                    min = employee.getEmployeeSalary();
                    minSalaryEmployee = employee.getEmployeeFullName();
                }
            }
        }
        System.out.println("Минимальная зарплата: " + min + " руб. Сотрудник - " + minSalaryEmployee);
    }

    public void findMaxSalary(Employee[] employees) {
        int max = 0;
        String maxSalaryEmployee = "";
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getEmployeeSalary() > max) {
                    max = employee.getEmployeeSalary();
                    maxSalaryEmployee = employee.getEmployeeFullName();
                }
            }
        }
        System.out.println("Максимальная зарплата: " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public float calculateAverageSalary(Employee[] employees) {
        float sum = 0;
        int salaryCounter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getEmployeeSalary();
                salaryCounter++;
            }
        }
        return sum / salaryCounter;
    }

    public void findAllFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Ф.И.О. - " + employee.getEmployeeFullName());
            }
        }
    }

    public void indexSalary(Employee[] employees, int indexPercent) {
        int increaseSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                increaseSalary = employee.getEmployeeSalary() * (100 + indexPercent) / 100;
                System.out.println("Сотрудник - " + employee.getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
            }
        }
    }

    public void findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int min = Integer.MAX_VALUE;
        String minSalaryEmployee = "";
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber && employee.getEmployeeSalary() < min) {
                    min = employee.getEmployeeSalary();
                    minSalaryEmployee = employee.getEmployeeFullName();
                }
            }
        }
        System.out.println("Минимальная зарплата в отделе " + departmentNumber + " - " + min + " руб. Сотрудник - " + minSalaryEmployee);

    }

    public void findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int max = 0;
        String maxSalaryEmployee = "";
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber && employee.getEmployeeSalary() >= max) {
                    max = employee.getEmployeeSalary();
                    maxSalaryEmployee = employee.getEmployeeFullName();
                }
            }
        }
        System.out.println("Максимальная зарплата в отделе " + departmentNumber + " - " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public void findTotalSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber) {
                    sum = sum + employee.getEmployeeSalary();
                }
            }
        }
        System.out.println("Общие затраты на зарплату в отделе " + departmentNumber + " - " + sum + " руб.");
    }

    public void findAverageSalaryInDepartment(Employee[] employees, int departmentNumber) {
        float sum = 0;
        int salaryCounter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber) {
                    sum = sum + employee.getEmployeeSalary();
                    salaryCounter++;
                }
            }
        }
        float average = sum / salaryCounter;
        System.out.println("Средняя зарплата в отделе " + departmentNumber + " - " + average + " руб.");
    }

    public void indexSalaryInDepartment(Employee[] employees, int departmentNumber, int indexPercent) {
        int increaseSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber) {
                    increaseSalary = employee.getEmployeeSalary() * (100 + indexPercent) / 100;
                    System.out.println("Сотрудник отдела " + departmentNumber + " - " + employee.getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
                }
            }
        }
    }

    public void printEmployeesOfDepartment(Employee[] employees, int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartmentNumber() == departmentNumber) {
                    System.out.println("Сотрудник отдела " + departmentNumber + " - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
                }
            }
        }
    }

    public void findSalaryMoreThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getEmployeeSalary() > salaryLimit) {
                    System.out.println("Сотрудник, чья зарплата превышает установленный уровень - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
                }
            }
        }
    }

    public void findSalaryLessThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getEmployeeSalary() <= salaryLimit) {
                    System.out.println("Сотрудник, чья зарплата не превышает установленный уровень - " + employee.getEmployeeFullName() + ", размер зарплаты - " + employee.getEmployeeSalary() + ", id = " + employee.getId());
                }
            }
        }
    }

    public void addEmployee(Employee[] employees, String employeeFullName, int departmentNumber, int employeeSalary) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(employeeFullName, departmentNumber, employeeSalary);
                System.out.println("Новый сотрудник - " + employees[i]);
                break;
            } else if (employees[i] != null) {
                counter++;
                if (counter >= employees.length) {
                    System.out.println("Список переполнен. Добавление нового сотрудника невозможно");
                }
            }
        }
    }

    public void removeEmployee(Employee[] employees, String employeeFullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeFullName().equals(employeeFullName)) {
                    employees[i] = null;
                    System.out.println("Данные о сотруднике " + employeeFullName + " удалены");
                    break;
                }
            }
        }
    }

    public void changeEmployee(Employee[] employees, String employeeFullName, int newSalary, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeFullName().equals(employeeFullName)) {
                    employees[i].setEmployeeSalary(newSalary);
                    employees[i].setDepartmentNumber(newDepartment);
                    System.out.println("Сотрудник " + employees[i].getEmployeeFullName() + ", новая зарплата - " + employees[i].getEmployeeSalary() + ", новый отдел - " + employees[i].getDepartmentNumber());
                    break;
                }
            }
        }
    }

    public void printAllEmployeesInDepartment(Employee[] employees, int startingDepartmentNumber) {
        int maxDepartmentNumber = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() > maxDepartmentNumber) {
                    maxDepartmentNumber = employees[i].getDepartmentNumber();
                }
            }
        }
        for (int i1 = 0; i1 < maxDepartmentNumber; i1++) {
            System.out.print("Сотрудники отдела " + (startingDepartmentNumber + i1) + ": ");
            for (int i2 = 0; i2 < employees.length; i2++) {
                if (employees[i2] != null) {
                    if (employees[i2].getDepartmentNumber() == (startingDepartmentNumber + i1)) {
                        System.out.print(employees[i2].getEmployeeFullName() + ", ");
                    }
                }
            }
            System.out.println("");
        }
    }
}

