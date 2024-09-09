package com.wybank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountProductDTO {
    private Long accountProductId; // 상품코드
    private String accountType; //"저축예금", "정기적금", "정기예금", "주택청약저축",
    private String accountName; // 상품이름
    private String accountMemo; // 상품한줄설명
    private String accountDescription;
    private Long inBankFees; // 현행 수수료
    private Long outBankFees; // 타행 수수료
    private Long singleTransactionLimit; // 1회거래한도
    private Long dailyTransactionLimit; // 당일거래한도
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
