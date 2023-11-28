package com.codurance.lsp;

public abstract class Vehicle {


    private boolean engineStarted = false;

    public void fill() {
        if (this instanceof PetrolCar) {
            ((PetrolCar) this).fillUpWithFuel();
        }
        else if (this instanceof ElectricCar) {
            ((ElectricCar) this).chargeBattery();
        }
    }

    public void startEngine() {
        this.engineStarted = true;
    }

    public boolean engineIsStarted() {
        return engineStarted;
    }

    public void stopEngine() {
        this.engineStarted = false;
    }
}
