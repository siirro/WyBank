package com.wybank.account.repository;

import com.wybank.account.domain.Account;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Log4j2
@ActiveProfiles("local")
public class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void test1() {
        Assertions.assertNotNull(accountRepository);
        log.info(accountRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Account account = Account.builder()
                .accountName("테스트계좌")
                .accountNumber("111-111-111-111")
                .accountState("active")
                .balance(0L)
                .createdAt(LocalDateTime.now())
                .userId("testId")
                .build();

        Account result = accountRepository.save(account);

        log.info("결과" + result);
    }

    @Test
    public void testFindAccountByAccountId() {
        Long accountId = 1L;

        Optional<Account> result = accountRepository.findById(accountId);
        Account account = result.orElseThrow();
        log.info("조회"+account);
    }

}
