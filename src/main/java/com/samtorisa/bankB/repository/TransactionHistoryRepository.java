package com.samtorisa.bankB.repository;

import com.samtorisa.bankB.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {

   /* @Query("SELECT e.account_id, e.transaction_type, e.transaction_amount, e.date_transaction, e.id " +
            "FROM transaction e " +
            "WHERE e.account_id = :accountIds " +
            "ORDER BY e.date_transaction DESC limit 5")*/


    List<TransactionHistory> findTop5ByAccountIdOrderByDateTransactionDesc(Long accountId);


}
