package com.zzt.behavioral.chain;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:26
 */
public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Message message) {
        String msg = message.getMsg();
        msg = msg.replace("996", "955");
        message.setMsg(msg);
        return true;
    }
}
