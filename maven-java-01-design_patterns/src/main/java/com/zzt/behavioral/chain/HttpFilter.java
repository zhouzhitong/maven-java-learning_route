package com.zzt.behavioral.chain;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:24
 */
public class HttpFilter implements Filter {
    @Override
    public boolean doFilter(Message message) {
        String msg = message.getMsg();
        msg = msg.replace('<', '[');
        msg = msg.replace('>', ']');
        message.setMsg(msg);
        return true;
    }
}
