package com.wybank.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountProductId; // 상품코드
    private String accountType; //"저축예금", "정기적금", "정기예금", "주택청약저축",
    private String accountName; // 상품이름
    private Long inBankFees; // 현행 수수료
    private Long outBankFees; // 타행 수수료
    private Long singleTransactionLimit; // 1회거래한도
    private Long dailyTransactionLimit; // 당일거래한도

}
