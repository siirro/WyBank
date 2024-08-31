package com.wybank.account.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String userId;
    private Long bankId;
    private String accountNumber;
    private String accountName; // 계좌별명
    private String accountMemo; // 계좌메모
    private Long balance; // 계좌잔액
    private String accountState; // "active:활성","frozen:정지","dormant:휴면"(1년 미사용)
    private boolean isClosed; // 삭제된 계좌
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;
}

