package com.codurance.ocp;

public class Engineer extends Employee {

    public Engineer(int salary) {
        super(salary);
    }

    public int payAmount() {
        return salary;
    }
}
