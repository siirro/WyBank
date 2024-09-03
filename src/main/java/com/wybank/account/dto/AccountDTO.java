package com.wybank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // JSON 으로 변환할때 비어있는 생성자 필요
public class AccountDTO {

    private Long accountId;
    private String userId;
    private Long bankId;
    private String accountNumber;
    private String accountName; // 계좌이름
    private String accountMemo; // 계좌메모
    private Long balance; // 계좌잔액
    private String accountState; // "active:활성","frozen:정지","dormant:휴면"(1년 미사용)
    private boolean isClosed; // 삭제된 계좌
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;
}
