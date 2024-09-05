package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.dto.AccountDTO;
import com.wybank.dto.PageRequestDTO;
import com.wybank.dto.PageResponseDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface AccountService {
    AccountDTO get(Long accountId);

    Long create(AccountDTO dto);

    void updateMemo(AccountDTO dto);
    void updateBalance(AccountDTO dto);
    void delete(Long accountId);

    PageResponseDTO<AccountDTO> getList(PageRequestDTO pageRequestDTO);

    default AccountDTO entityToDTO(Account account) {
        return
                AccountDTO.builder()
                        .accountId(account.getAccountId())
                        .userId(account.getUserId())
                        .bankId(account.getBankId())
                        .accountNumber(account.getAccountNumber())
                        .accountProductId(account.getAccountProductId())
                        .accountMemo(account.getAccountMemo())
                        .accountPw(account.getAccountPw())
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
                        .accountProductId(accountDTO.getAccountProductId())
                        .accountMemo(accountDTO.getAccountMemo())
                        .accountPw(accountDTO.getAccountPw())
                        .balance(accountDTO.getBalance())
                        .accountState(accountDTO.getAccountState())
                        .isClosed(accountDTO.isClosed())
                        .createdAt(accountDTO.getCreatedAt())
                        .updatedAt(accountDTO.getUpdatedAt())
                        .closedAt(accountDTO.getClosedAt())
                        .build();

    }
}