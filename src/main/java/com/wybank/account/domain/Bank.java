package com.wybank.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import javax.persistence.GeneratedValue;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    private Long bankId;
    private String bankName;
}
