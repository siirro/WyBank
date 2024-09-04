package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface AccountService {
    AccountDTO get(Long account_id);

    Long create(AccountDTO dto);

    void updateBalance(AccountDTO dto);
    void delete(Long accountId);

    default AccountDTO entityToDTO(Account account) {
        return
                AccountDTO.builder()
                        .accountId(account.getAccountId())
                        .userId(account.getUserId())
                        .bankId(account.getBankId())
                        .accountNumber(account.getAccountNumber())
                        .accountName(account.getAccountName())
                        .accountMemo(account.getAccountMemo())
                        .balance(account.getBalance())
                        .accountState(account.getAccountState())
                        .isClosed(account.isClosed())
                        .createdAt(account.getCreatedAt())
                        .updatedAt(account.getUpdatedAt())
                        .closedAt(account.getClosedAt())
                        .build();
    }

    default Account dtoToEntity(AccountDTO accountDTO) {
        return
                Account.builder()
                        .accountId(accountDTO.getAccountId())
                        .userId(accountDTO.getUserId())
                        .bankId(accountDTO.getBankId())
                        .accountNumber(accountDTO.getAccountNumber())
                        .accountName(accountDTO.getAccountName())
                        .accountMemo(accountDTO.getAccountMemo())
                        .balance(accountDTO.getBalance())
                        .accountState(accountDTO.getAccountState())
                        .isClosed(accountDTO.isClosed())
                        .createdAt(accountDTO.getCreatedAt())
                        .updatedAt(accountDTO.getUpdatedAt())
                        .closedAt(accountDTO.getClosedAt())
                        .build();

    }
}