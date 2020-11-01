package com.zzt.structureType.bridging.demo01.remotes;

import com.zzt.structureType.bridging.demo01.devices.Device;

/**
 * 描述：<br>远程控制器 --- 高级远程控制器
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/1 22:53
 **/
public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
