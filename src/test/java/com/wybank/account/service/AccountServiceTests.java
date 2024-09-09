package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import com.wybank.dto.PageRequestDTO;
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
        for(int i = 0; i<30; i++) {
            AccountDTO dto = AccountDTO.builder()
                    .accountProductId(1L)
                    .accountNumber("111-111-111-111")
                    .accountState("active")
                    .balance(0L)
                    .createdAt(LocalDateTime.now())
                    .userId("testId"+i)
                    .build();

            log.info("만들어진계좌의번호는?"+accountService.create(dto));
        }
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

    @Test
    public void testGetList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(2).build();

        log.info("page처리"+accountService.getList(pageRequestDTO));
    }
}
