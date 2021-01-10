package com.zzt.tx.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     结账：传入哪个用户买了哪本书
     减库存、减账户余额【table_name: book_store、account】
     @param username 用户名
     @param id       书的ID
     @return null
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW
//            , noRollbackFor = {ArithmeticException.class, UnexpectedRollbackException.class}
    )
    public void checkout(String username, int id) {
        System.out.println("############### 111111 ###############");
        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        int i = 1 / 0;
        bookDao.updateBalance(username, price);
    }

    /**
     更新价格【table_name: book】
     @param id    书的ID
     @param price 书的新价格
     */
    @Transactional
    public void updatePrice(int id, int price) {
        System.out.println("############### 222222 ###############");
        bookDao.updatePrice(id, price);
//        int i = 1 / 0;
    }
}