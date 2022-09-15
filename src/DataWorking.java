public class DataWorking {
    public static void showAllData(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public static int calculateSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getEmployeeSalary();
            }
        }
        return sum;
    }

    public static void findMinSalary(Employee[] employees) {
        int min = Integer.MAX_VALUE;
        String minSalaryEmployee = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeSalary() < min) {
                    min = employees[i].getEmployeeSalary();
                    minSalaryEmployee = employees[i].getEmployeeFullName();
                }
            }
        }
        System.out.println("Минимальная зарплата: " + min + " руб. Сотрудник - " + minSalaryEmployee);
    }

    public static void findMaxSalary(Employee[] employees) {
        int max = 0;
        String maxSalaryEmployee = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeSalary() > max) {
                    max = employees[i].getEmployeeSalary();
                    maxSalaryEmployee = employees[i].getEmployeeFullName();
                }
            }
        }
        System.out.println("Максимальная зарплата: " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public static float calculateAverageSalary(Employee[] employees) {
        float sum = 0;
        int salaryCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getEmployeeSalary();
                salaryCounter++;
            }
        }
        return sum / salaryCounter;
    }

    public static void findAllFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Ф.И.О. - " + employee.getEmployeeFullName());
            }
        }
    }

    public static void indexSalary(Employee[] employees, int indexPercent) {
        int increaseSalary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                increaseSalary = employees[i].getEmployeeSalary() * (100 + indexPercent) / 100;
                System.out.println("Сотрудник - " + employees[i].getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
            }
        }
    }

    public static void findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int min = Integer.MAX_VALUE;
        String minSalaryEmployee = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber && employees[i].getEmployeeSalary() < min) {
                    min = employees[i].getEmployeeSalary();
                    minSalaryEmployee = employees[i].getEmployeeFullName();
                }
            }
        }
        System.out.println("Минимальная зарплата в отделе " + departmentNumber + " - " + min + " руб. Сотрудник - " + minSalaryEmployee);
    }

    public static void findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int max = 0;
        String maxSalaryEmployee = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber && employees[i].getEmployeeSalary() > max) {
                    max = employees[i].getEmployeeSalary();
                    maxSalaryEmployee = employees[i].getEmployeeFullName();
                }
            }
        }
        System.out.println("Максимальная зарплата в отделе " + departmentNumber + " - " + max + " руб. Сотрудник - " + maxSalaryEmployee);
    }

    public static void findTotalSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber) {
                    sum = sum + employees[i].getEmployeeSalary();
                }
            }
        }
        System.out.println("Общие затраты на зарплату в отделе " + departmentNumber + " - " + sum + " руб.");
    }

    public static void findAverageSalaryInDepartment(Employee[] employees, int departmentNumber) {
        int sum = 0;
        int salaryCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber) {
                    sum = sum + employees[i].getEmployeeSalary();
                    salaryCounter++;
                }
            }
        }
        float average = (float) sum / salaryCounter;
        System.out.println("Средняя зарплата в отделе " + departmentNumber + " - " + average + " руб.");
    }

    public static void indexSalaryInDepartment(Employee[] employees, int departmentNumber, int indexPercent) {
        int increaseSalary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber) {
                    increaseSalary = employees[i].getEmployeeSalary() * (100 + indexPercent) / 100;
                    System.out.println("Сотрудник отдела " + departmentNumber + " - " + employees[i].getEmployeeFullName() + ", увеличенная зарплата - " + increaseSalary + " руб.");
                }
            }
        }
    }

    public static void printEmployeesOfDepartment(Employee[] employees, int departmentNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartmentNumber() == departmentNumber) {
                    System.out.println("Сотрудник отдела " + departmentNumber + " - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
                }
            }
        }
    }

    public static void findSalaryMoreThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeSalary() > salaryLimit) {
                    System.out.println("Сотрудник, чья зарплата превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
                }
            }
        }
    }

    public static void findSalaryLessThanSalaryLimit(Employee[] employees, int salaryLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeSalary() <= salaryLimit) {
                    System.out.println("Сотрудник, чья зарплата не превышает установленный уровень - " + employees[i].getEmployeeFullName() + ", размер зарплаты - " + employees[i].getEmployeeSalary() + ", id = " + employees[i].getId());
                }
            }
        }
    }
}
