package com.zzt.tx.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * ��ȥĳ���û������
     * @param userName
     * @param price
     */
    public void updateBalance(String userName,int price){
        String sql = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    /**
     * ����ͼ���id����ȡͼ��ļ۸�
     * @param id
     * @return
     */
    public int getPrice(int id){
        String sql = "select price from book where id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }

    /**
     * ����棬��ȥĳ����Ŀ��
     * @param id
     */
    public void updateStock(int id){
        String sql = "update book_stock set stock=stock-1 where id=?";
        jdbcTemplate.update(sql,id);
    }

    /**
     * �޸�ͼ��۸�
     * @param id
     * @param price
     */
    public void updatePrice(int id,int price){
        String sql = "update book set price=? where id =?";
        jdbcTemplate.update(sql,price,id);
    }
}