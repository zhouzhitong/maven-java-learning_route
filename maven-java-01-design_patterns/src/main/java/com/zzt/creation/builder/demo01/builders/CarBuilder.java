package com.zzt.creation.builder.demo01.builders;

import com.zzt.creation.builder.demo01.Builder;
import com.zzt.creation.builder.demo01.Car;
import com.zzt.creation.builder.demo01.components.Engine;
import com.zzt.creation.builder.demo01.components.CarType;
import com.zzt.creation.builder.demo01.components.GPSNavigator;
import com.zzt.creation.builder.demo01.components.Transmission;
import com.zzt.creation.builder.demo01.components.TripComputer;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 18:07
 */
public class CarBuilder implements Builder<Car> {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    @Override
    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}