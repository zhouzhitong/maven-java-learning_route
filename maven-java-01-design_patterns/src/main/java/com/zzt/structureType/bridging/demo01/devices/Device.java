package com.zzt.structureType.bridging.demo01.devices;

/**
 * 描述：<br>所有设备的通用接口
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/1 22:48
 **/
public interface Device {
    /** 判断是否可用 */
    boolean isEnabled();
    /** 设置可用 */
    void enable();

    /** 设置不可用 */
    void disable();

    /** 获取 音量 */
    int getVolume();

    /** 设置 音量 */
    void setVolume(int percent);

    /** 获取 通道 */
    int getChannel();

    /** 设置 通道 */
    void setChannel(int channel);

    /** 打印状态 */
    void printStatus();
}
