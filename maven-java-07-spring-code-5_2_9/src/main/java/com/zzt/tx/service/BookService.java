package com.zzt.tx.service;

import com.zzt.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     *
     * @param username
     * @param id
     * @see Transactional
     * isolation：设置事务的隔离级别
     * ?		propagation：事务的传播行为
     * ?		noRollbackFor：那些异常事务可以不回滚
     * ?		noRollbackForClassName：填写的参数是全类名
     * ?		rollbackFor：哪些异常事务需要回滚
     * ?		rollbackForClassName：填写的参数是全类名
     * ?		readOnly：设置事务是否为只读事务
     * ?		timeout：事务超出指定执行时长后自动终止并回滚,单位是秒
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED
//            , noRollbackFor = {ArithmeticException.class}
            , rollbackFor = {FileNotFoundException.class}
    )
    public void checkout(String username, int id) throws FileNotFoundException {
        // 减库存
        bookDao.buyOneBookToUpdateStock(id);
        int price = bookDao.getBookOfPrice(id);
//        int i = 1 / 0;
        // 减账户余额
        bookDao.minusAndUpdateBalance(username, price);
        new FileInputStream("aaa.txt");
    }

}
