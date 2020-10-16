package com.zzt.creation.builder.demo01;

import com.zzt.creation.builder.demo01.components.*;

/**
 * 描述：<br>建造者
 * Builder interface defines all possible ways to configure a product.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 18:00
 */
public interface Builder<T> {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);

    T getResult();

}
