package com.wybank.account.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_closed=false")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long accountId;
    private String userId;
    private Long bankId;
    private String accountNumber;
    private String accountName; // 계좌이름
    private String accountMemo; // 계좌메모
    private Long balance; // 계좌잔액
    private String accountState; // "active:활성","frozen:정지","dormant:휴면"(1년 미사용)
    private boolean isClosed; // 삭제된 계좌
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;

    public void changeAccountMemo(String accountMemo) {
        this.accountMemo = accountMemo;
    }
    public void changeBalance(Long balance) {
        this.balance = balance;
    }
    public void changeUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

