package org.Control5.Task1.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void calculateFuelReserve() {
        Car car = new Car("Lexus",100, 10, "O111OO77");
        Assertions.assertEquals(car.calculateFuelReserve(), 10);
    }

    @Test
    void makeSound() {
        Car car = new Car("Lexus",100, 10, "O111OO77");

        String s = car.makeSound(4);
        Assertions.assertEquals(s, "BEEEEP!");
    }

}