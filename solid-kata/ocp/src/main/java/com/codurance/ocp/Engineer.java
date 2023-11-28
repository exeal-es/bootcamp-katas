package com.codurance.ocp;

public class Engineer extends Employee {

    public Engineer(int salary, int bonus) {
        super(salary, bonus, EmployeeType.ENGINEER);
    }
}
