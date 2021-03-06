package org.sample.springmvc.extra;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
// rollbackForでExceptionを指定すると、指定したExceptionが発生した場合にロールバックが行われる
// @Transactional(rollbackFor=Exception.class)
// @Transactionalが指定されている場合、transactionManagerを使用した明示的なトランザクション制御はできない。どちらかだけ使う
// @Transactional
public class DBAccess {
    @Autowired SqlMapper sqlMapper;
    @Autowired PlatformTransactionManager transactionManager;

    // TransactionTemplate版
    public List<TestTable> dbAccess() {
        // TransactionCallbackは一つのメソッドを持つインタフェースなので、以下のように関数型インタフェースとして扱うことができる
        return new TransactionTemplate(transactionManager).execute(status -> {
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            status.setRollbackOnly();
            return list;
        });
    }

    // UserTransaction版
    public List<TestTable> _dbAccess() throws Throwable {
        JtaTransactionManager jtaTx = (JtaTransactionManager) transactionManager;
        UserTransaction uTx = jtaTx.getUserTransaction();
        List<TestTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
             list = sqlMapper.selectTestTables(1, "false", "a");
        } catch (NotSupportedException | SystemException e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
