package com.fintrack.domain.monthly_statement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MonthlyStatementRepository {

    MonthlyStatement save(MonthlyStatement monthlyStatement);
    Optional<MonthlyStatement> findById(UUID statementId);
    Optional<MonthlyStatement> findByUserIdAndReference(UUID userId, String reference);
    List<MonthlyStatement> findAllByUserIdOrderByReferenceDesc(UUID userId);

}

