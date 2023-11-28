package com.codurance.lsp;

public class FillingStation {

    public void fill(Vehicle vehicle) {
        if (vehicle instanceof PetrolCar) {
            ((PetrolCar)vehicle).fillUpWithFuel();
        }
        else if (vehicle instanceof ElectricCar) {
            ((ElectricCar)vehicle).chargeBattery();
        }
    }
}
