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
     * ���ˣ������ĸ��û������ı���
     *
     * @param username
     * @param id
     * @see Transactional
     * isolation����������ĸ��뼶��
     * ?		propagation������Ĵ�����Ϊ
     * ?		noRollbackFor����Щ�쳣������Բ��ع�
     * ?		noRollbackForClassName����д�Ĳ�����ȫ����
     * ?		rollbackFor����Щ�쳣������Ҫ�ع�
     * ?		rollbackForClassName����д�Ĳ�����ȫ����
     * ?		readOnly�����������Ƿ�Ϊֻ������
     * ?		timeout�����񳬳�ָ��ִ��ʱ�����Զ���ֹ���ع�,��λ����
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED
//            , noRollbackFor = {ArithmeticException.class}
            , rollbackFor = {FileNotFoundException.class}
    )
    public void checkout(String username, int id) throws FileNotFoundException {
        // �����
        bookDao.buyOneBookToUpdateStock(id);
        int price = bookDao.getBookOfPrice(id);
//        int i = 1 / 0;
        // ���˻����
        bookDao.minusAndUpdateBalance(username, price);
        new FileInputStream("aaa.txt");
    }

}
