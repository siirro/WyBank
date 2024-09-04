package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import com.wybank.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDTO get(Long accountId) {

        Optional<Account> result = accountRepository.findById(accountId);
        Account account = result.orElseThrow();
        return entityToDTO(account);
    }

    @Override
    public Long create(AccountDTO dto) {
        Account account = dtoToEntity(dto);
        Account result = accountRepository.save(account);
        return result.getAccountId();
    }

    @Override
    public void updateBalance(AccountDTO dto) {
        Optional<Account> result = accountRepository.findById(dto.getAccountId());
        Account account = result.orElseThrow();
        account.changeBalance(account.getBalance() + dto.getBalance());
        account.changeUpdatedAt(dto.getUpdatedAt());

        accountRepository.save(account);
    }

    @Override
    public void delete(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
