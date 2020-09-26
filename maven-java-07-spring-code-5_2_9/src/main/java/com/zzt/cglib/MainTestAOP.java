package com.zzt.cglib;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 17:41
 */
public class MainTestAOP {

    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        UserService userService = (UserService) userServiceProxy.getProxy(UserService.class);
        userService.print();
    }

}
