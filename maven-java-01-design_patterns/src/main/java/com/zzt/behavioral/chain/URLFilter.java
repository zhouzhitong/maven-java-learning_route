package com.zzt.behavioral.chain;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:46
 */
public class URLFilter implements Filter {
    @Override
    public boolean doFilter(Message message) {
        String msg = message.getMsg();
        msg = msg.replace("http://mashibing.com", "http://www.mashibing.com");
        message.setMsg(msg);
        return false;
    }
}
