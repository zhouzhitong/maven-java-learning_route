package com.zzt.spring.cycle;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/3 15:15
 */
public class BToA {
    private AToB a;

    public BToA() {
    }

    public BToA(AToB a) {
        this.a = a;
    }

    public AToB getA() {
        return a;
    }

    public void setA(AToB a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "BToA{" +
                "a=" + a +
                '}';
    }
}
