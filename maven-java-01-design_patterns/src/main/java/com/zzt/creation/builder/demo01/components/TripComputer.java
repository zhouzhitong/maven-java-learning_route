package com.zzt.creation.builder.demo01.components;

import com.zzt.creation.builder.demo01.Car;

/**
 * 描述：<br>
 * Just another feature of a car.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 18:04
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
