package com.codurance.ocp;

public abstract class Employee {

    protected int salary;

    protected Employee(int salary) {
        this.salary = salary;
    }

    static Employee createEngineer(int salary) {
        return new Engineer(salary);
    }

    static Employee createManager(int salary, int bonus) {
        return new Manager(salary, bonus);
    }

    public abstract int payAmount();
}