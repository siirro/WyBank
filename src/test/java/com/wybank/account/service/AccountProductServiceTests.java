package com.wybank.account.service;

import com.wybank.account.dto.AccountProductDTO;
import com.wybank.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Log4j2
@ActiveProfiles("local")
public class AccountProductServiceTests {

    @Autowired
    AccountProductService accountProductService;

    @Test
    public void testCreate() {
        for(int i = 1; i<=30; i++) {
            AccountProductDTO dto = AccountProductDTO.builder()
                    .accountType("test")//"자유입출금상품", "정기적금", "정기예금", "주택청약저축",
                    .accountName("Wy test product "+i)
                    .accountMemo("test memo "+i)
                    .accountDescription("test description")
                    .singleTransactionLimit(1000000L)
                    .dailyTransactionLimit(5000000L)
                    .build();

            log.info("계좌상품" + accountProductService.create(dto));
        }
    }

    @Test
    public void testGetList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).build();
        log.info("AccountProductListWithPage"+accountProductService.getList(pageRequestDTO));
    }
}
