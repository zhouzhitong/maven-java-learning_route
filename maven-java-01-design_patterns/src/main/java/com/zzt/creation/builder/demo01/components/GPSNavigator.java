package com.zzt.creation.builder.demo01.components;

/**
 * 描述：<br>
 * Just another feature of a car.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 18:03
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
