package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import com.wybank.account.repository.AccountRepository;
import com.wybank.dto.PageRequestDTO;
import com.wybank.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void updateMemo(AccountDTO dto) {
        Optional<Account> result = accountRepository.findById(dto.getAccountId());
        Account account = result.orElseThrow();
        account.changeAccountMemo(dto.getAccountMemo());
        accountRepository.save(account);
    };

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

    @Override
    public PageResponseDTO<AccountDTO> getList(PageRequestDTO pageRequestDTO) {
        // JPA
        Page<Account> result = accountRepository.search1(pageRequestDTO);
        List<AccountDTO> dtoList = result.get().map(account -> entityToDTO(account)).collect(Collectors.toList());

        PageResponseDTO<AccountDTO> pageResponseDTO = PageResponseDTO.<AccountDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(result.getTotalElements()).build();

        return pageResponseDTO;
    }
}
