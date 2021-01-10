package com.zzt.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * ��ȥĳ���û������
     * minus
     * @param userName
     * @param price
     */
    public void minusAndUpdateBalance(String userName, int price) {
        String sql = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql, price, userName);
    }

    /**
     * ����ͼ���id����ȡͼ��ļ۸�
     *
     * @param id
     * @return
     */
    public int getBookOfPrice(int id) {
        String sql = "select price from book where id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }

    /**
     * ����棬��ȥĳ����Ŀ��
     *
     * @param id
     */
    public void buyOneBookToUpdateStock(int id) {
        String sql = "update book_stock set stock=stock-1 where id=?";
        jdbcTemplate.update(sql, id);
    }
}