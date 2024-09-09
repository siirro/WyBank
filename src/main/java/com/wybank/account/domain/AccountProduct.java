package com.wybank.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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
    private String accountType; //"자유입출금상품", "정기적금", "정기예금", "주택청약저축",
    private String accountName; // 상품이름
    private String accountMemo; // 상품한줄설명
    private String accountDescription; // 상품상세설명
    private Long inBankFees; // 현행 수수료
    private Long outBankFees; // 타행 수수료
    private Long singleTransactionLimit; // 1회거래한도
    private Long dailyTransactionLimit; // 당일거래한도
    private boolean isDeleted;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public void changeIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
