package com.fintrack.domain.bank_account;

import com.fintrack.domain.recurring_bill.RecurringBill;
import com.fintrack.domain.shared.AccountType;
import com.fintrack.domain.transaction.Transaction;
import com.fintrack.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecurringBill> recurringBills = new ArrayList<>();

    @OneToMany(mappedBy = "bankAccount")
    private List<Transaction> transactions = new ArrayList<>();
}
