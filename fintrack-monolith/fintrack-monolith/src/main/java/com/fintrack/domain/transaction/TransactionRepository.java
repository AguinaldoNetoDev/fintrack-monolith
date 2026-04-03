package com.fintrack.domain.transaction;

import com.fintrack.domain.shared.Classification;
import com.fintrack.domain.shared.TransactionBillType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {

    Transaction save(Transaction transaction);
    void deleteById(UUID transactionId);
    Optional<Transaction> findById(UUID transactionId);
    List<Transaction> findByStatementId(UUID statementId);
    List<Transaction> findByMemberId(UUID memberId);
    List<Transaction> findByBankAccountId(UUID bankAccountId);
    List<Transaction> findByClassification(Classification classification);
    List<Transaction> findByTransactionBillType(TransactionBillType transactionBillType);

}
