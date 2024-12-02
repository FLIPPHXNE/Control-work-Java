package org.Control5.Task1.Main;
import org.Control5.Task1.Interface.ITransport;

public class Car implements ITransport {
    private String brand;
    private int fuelInTank;
    private double fuelConsumptionPer100km;
    private String licensePlate;

    public Car(String brand, int fuelTank, double fuelConsumptionPer100km, String numberPlate) {
        this.brand = brand;
        this.fuelInTank = fuelTank;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
        this.licensePlate = numberPlate;
    }


    @Override
    public double calculateFuelReserve(){
        double result = fuelInTank/fuelConsumptionPer100km;
        System.out.println("Топлива осталось на %f км.".formatted(result));
        return result;
    }

    @Override
    public String getNumberLicense(){
        return this.licensePlate;
    }

    @Override
    public String makeSound(int t){
        String s = "B";
        for(int i = 0; i < t; i++) {
            s += "E";
        }
        s += "P!";
        System.out.println(s);
        return s;
    }
}
