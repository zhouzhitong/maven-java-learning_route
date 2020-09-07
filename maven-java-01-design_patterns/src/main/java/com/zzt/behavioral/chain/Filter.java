package com.zzt.behavioral.chain;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:24
 */
public interface Filter {

    boolean doFilter(Message message);

}
