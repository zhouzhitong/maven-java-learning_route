package com.zzt.behavioral.chain;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 15:19
 */
public class Client {

    public static void main(String[] args) {
        Message message = new Message();
        message.setName("张三");
        message.setMsg("大家好：) <script>,欢迎返回 http://mashibing.com,大家都是996");

        FilterChain chain = new FilterChain();
        chain.add(new HttpFilter()).add(new SensitiveFilter());

        FilterChain chain1 = new FilterChain();
        chain1.add(chain).add(new URLFilter());
        chain1.doFilter(message);

        System.out.println(message);

    }

}
