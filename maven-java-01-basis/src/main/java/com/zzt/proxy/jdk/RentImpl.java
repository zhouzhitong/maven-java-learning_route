package com.zzt.proxy.jdk;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/20 20:11 **/
public class RentImpl implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子了！");
    }
}
