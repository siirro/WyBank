package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
@ActiveProfiles("local")
public class AccountServiceTests {

    @Autowired
    AccountService accountService;

    @Test
    public void testGet() {
        Long accountId = 1L;
        log.info(accountService.get(accountId));
    }

    @Test
    public void testCreate() {
        AccountDTO dto = AccountDTO.builder()
                .accountName("서비스테스트")
                .accountNumber("111-111-111-111")
                .accountState("active")
                .balance(0L)
                .createdAt(LocalDateTime.now())
                .userId("testId")
                .build();

        log.info("만들어진계좌의번호는?"+accountService.create(dto));
    }

    @Test
    public void testUpdate() {
        Long accountId = 1L;

        AccountDTO dto = AccountDTO.builder()
                .accountId(accountId)
                .balance(20000L)
                .updatedAt(LocalDateTime.now())
                .build();

        log.info(LocalDateTime.now());
        accountService.updateBalance(dto);

    }
}
