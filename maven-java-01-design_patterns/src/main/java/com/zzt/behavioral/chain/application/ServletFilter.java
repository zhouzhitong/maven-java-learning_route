package com.zzt.behavioral.chain.application;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:54
 */
public interface ServletFilter {

    void doFilter(Request request, Response response);

}
