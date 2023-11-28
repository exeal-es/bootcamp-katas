package com.codurance.ocp;

public class Manager extends Employee {
    private final int bonus;

    public Manager(int salary, int bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public int payAmount() {
        return salary + bonus;
    }
}
