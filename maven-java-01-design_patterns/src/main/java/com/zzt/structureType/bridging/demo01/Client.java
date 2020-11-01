package com.zzt.structureType.bridging.demo01;

import com.zzt.structureType.bridging.demo01.devices.Device;
import com.zzt.structureType.bridging.demo01.devices.Radio;
import com.zzt.structureType.bridging.demo01.devices.Tv;
import com.zzt.structureType.bridging.demo01.remotes.AdvancedRemote;
import com.zzt.structureType.bridging.demo01.remotes.BasicRemote;
import com.zzt.structureType.bridging.demo01.remotes.Remote;

/**
 * 描述：<br>
 *     通过操作 远程控制器，来实现 对 所有设备的操作和使用。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/1 22:48
 **/
public class Client {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        Remote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
