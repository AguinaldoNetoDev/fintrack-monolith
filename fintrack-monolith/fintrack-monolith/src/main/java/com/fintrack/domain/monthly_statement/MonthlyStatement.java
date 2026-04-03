package com.fintrack.domain.monthly_statement;

import com.fintrack.domain.shared.StatementStatus;
import com.fintrack.domain.transaction.Transaction;
import com.fintrack.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "monthly_statements", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "reference"})
}) public class MonthlyStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 7, nullable = false)
    private String reference;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatementStatus status = StatementStatus.OPEN;

    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "statement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions =  new ArrayList<>();

}
