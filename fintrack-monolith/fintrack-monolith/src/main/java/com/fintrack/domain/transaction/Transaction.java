package com.fintrack.domain.transaction;

import com.fintrack.domain.bank_account.BankAccount;
import com.fintrack.domain.member.Member;
import com.fintrack.domain.monthly_statement.MonthlyStatement;
import com.fintrack.domain.recurring_bill.RecurringBill;
import com.fintrack.domain.shared.TransactionBillType;
import com.fintrack.domain.shared.Classification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statement_id", nullable = false)
    private MonthlyStatement statement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurring_bill_id")
    private RecurringBill recurringBill;

    @Column(length = 150, nullable = false)
    private String description;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionBillType transactionBillType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Classification classification;

    @Column(name = "created_at")
    private Instant createdAt;

}
