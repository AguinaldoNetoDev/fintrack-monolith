package com.fintrack.domain.recurring_bill;

import com.fintrack.domain.bank_account.BankAccount;
import com.fintrack.domain.member.Member;
import com.fintrack.domain.shared.RecurringBillType;
import com.fintrack.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "recurring_bills")
public class RecurringBill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 150, nullable = false)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal referenceValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecurringBillType recurringBillType;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private boolean active = true;
}
