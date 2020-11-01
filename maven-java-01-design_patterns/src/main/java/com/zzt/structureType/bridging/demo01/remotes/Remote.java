package com.zzt.structureType.bridging.demo01.remotes;

/**
 * 描述：<br>所有远程控制器的通用接口
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/1 22:52
 **/
public interface Remote {

    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}
