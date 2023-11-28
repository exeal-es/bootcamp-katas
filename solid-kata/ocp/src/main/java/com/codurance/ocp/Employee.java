package com.codurance.ocp;

public class Employee {

    private int salary;
    private int bonus;
    private EmployeeType type;

    private Employee(int salary, int bonus, EmployeeType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    static Employee createEmployee(int salary, int bonus, EmployeeType type) {
        return new Employee(salary, bonus, type);
    }

    static Employee createEngineer(int salary, int bonus) {
        return createEmployee(salary, bonus, EmployeeType.ENGINEER);
    }

    static Employee createManager(int salary, int bonus) {
        return createEmployee(salary, bonus, EmployeeType.MANAGER);
    }

    public int payAmount() {
        switch (this.type) {
            case ENGINEER:
                return salary;
            case MANAGER:
                return salary + bonus;
            default:
                return 0;
        }
    }

}