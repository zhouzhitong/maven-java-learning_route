package com.zzt.tx.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    (propagation = Propagation.REQUIRED
            , noRollbackFor = {ArithmeticException.class, UnexpectedRollbackException.class}
    )
    public void mulTx() {
        /*try {
        } catch (Exception e) {
        }*/
        bookService.updatePrice(1, 111);
        bookService.checkout("zhangsan", 1);
        try {
        } catch (Exception e) {
            System.out.println("错误信息：" + e.getClass() + " -- " + e.getMessage());
        }
//        int i = 1 / 0;
    }
}