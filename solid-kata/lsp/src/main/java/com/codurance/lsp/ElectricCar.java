package com.codurance.lsp;

public class ElectricCar extends Vehicle{

    private static final int BATTERY_FULL = 100;
    private int batteryLevel;

    private void chargeBattery() {
        batteryLevel = BATTERY_FULL;
    }

    public int batteryLevel() {
        return batteryLevel;
    }

    public void fill() {
        this.chargeBattery();
    }
}
