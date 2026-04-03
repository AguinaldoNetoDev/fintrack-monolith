package com.fintrack.domain.member;

import com.fintrack.domain.recurring_bill.RecurringBill;
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
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecurringBill> recurringBills = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Transaction> transactions = new ArrayList<>();

}
