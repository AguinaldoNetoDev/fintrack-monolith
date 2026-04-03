package com.fintrack.domain.bank_account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankAccountRepository {

    BankAccount save(BankAccount bankAccount);
    void deleteById(UUID bankAccountId);
    Optional<BankAccount> findById(UUID bankAccountId);
    List<BankAccount> findAllByUserId(UUID userId);

}
