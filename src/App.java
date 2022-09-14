public class App {


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

        DataWorking.showAllData(employeeRepository);
        System.out.println("");

        DataWorking.calculateSalary(employeeRepository);
        System.out.println("Общие затраты на зарплату - " + DataWorking.calculateSalary(employeeRepository) + " руб.");
        System.out.println("");

        DataWorking.findMinSalary(employeeRepository);
        System.out.println("");

        DataWorking.findMaxSalary(employeeRepository);
        System.out.println("");

        DataWorking.calculateAverageSalary(employeeRepository);
        System.out.println("Средняя зарплата - " + DataWorking.calculateAverageSalary(employeeRepository) + " руб.");
        System.out.println("");

        DataWorking.findAllFullNames(employeeRepository);
        System.out.println("");

        int indexPercent = 11;
        DataWorking.indexSalary(employeeRepository, indexPercent);
        System.out.println("");

        int departmentNumber = 5;
        DataWorking.findMinSalaryInDepartment(employeeRepository, departmentNumber);
        DataWorking.findMaxSalaryInDepartment(employeeRepository, departmentNumber);
        DataWorking.findTotalSalaryInDepartment(employeeRepository, departmentNumber);
        DataWorking.findAverageSalaryInDepartment(employeeRepository, departmentNumber);
        int indexPercentInDepartment = 15;
        DataWorking.indexSalaryInDepartment(employeeRepository, departmentNumber, indexPercentInDepartment);
        DataWorking.printEmployeesOfDepartment(employeeRepository, departmentNumber);
        System.out.println("");

        int salaryLimit = 90_000;
        DataWorking.findSalaryMoreThanSalaryLimit(employeeRepository, salaryLimit);
        DataWorking.findSalaryLessThanSalaryLimit(employeeRepository, salaryLimit);
        System.out.println("");

    }
}
