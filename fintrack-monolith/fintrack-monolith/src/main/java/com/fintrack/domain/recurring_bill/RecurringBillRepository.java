package com.fintrack.domain.recurring_bill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecurringBillRepository {

    RecurringBill save(RecurringBill recurringBill);
    void deleteById(UUID recurringBillId);
    Optional<RecurringBill> findById(UUID recurringBillId);
    List<RecurringBill> findAllActiveByUserId(UUID userId);
    List<RecurringBill> findAllByUserId(UUID userId);
}
