package com.codurance.ocp;

public class Employee {

    protected int salary;
    private int bonus;
    private EmployeeType type;

    protected Employee(int salary, int bonus, EmployeeType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    static Employee createEngineer(int salary, int bonus) {
        return new Engineer(salary, bonus);
    }

    static Employee createManager(int salary, int bonus) {
        return new Manager(salary, bonus);
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