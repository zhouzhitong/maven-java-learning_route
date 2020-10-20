package com.zzt.struct.andCollect;

import com.zzt.struct.andCollect.model.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 22:27
 **/
public class Main {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        UnionSet<Integer> unionSet = new UnionSet<>(list);
        unionSet.union(1, 2);
        unionSet.union(2, 3);
        boolean sameSet = unionSet.isSameSet(1, 3);
        System.out.println(sameSet);

        Node<Integer> father = unionSet.findFather(new Node<>(3));
        System.out.println(father);

    }

}
