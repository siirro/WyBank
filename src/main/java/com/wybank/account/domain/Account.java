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
//@Where(clause = "is_closed=false")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long accountId;
    private String userId;
    private Long bankId;
    private String accountNumber;
    private Long accountProductId; // 계좌 상품 ID
    private String accountMemo; // 계좌메모
    private String accountState; // "활성","정지","휴면"(1년 미사용) "active:frozen:dormant"
    private String accountPw; // 계좌비밀번호 (암호화)
    private Long balance; // 계좌잔액
    private boolean isClosed; // 1:해지계좌
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

