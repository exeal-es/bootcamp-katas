package com.codurance.ocp;

public class Manager extends Employee {
    private final int bonus;

    public Manager(int salary, int bonus) {
        super(salary, bonus, EmployeeType.MANAGER);
        this.bonus = bonus;
    }

    public int payAmount() {
        return salary + bonus;
    }
}
