package com.zzt.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:29
 */
public class FilterChain implements Filter {

    private List<Filter> filters;

    public FilterChain() {
        filters = new ArrayList<>();
    }

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Message message) {
        for (Filter filter : filters) {
            if (!filter.doFilter(message)) {
                return false;
            }
        }
        return true;
    }
}
