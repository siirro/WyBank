package com.wybank.account.service;


import com.wybank.account.domain.AccountProduct;
import com.wybank.account.dto.AccountProductDTO;
import com.wybank.dto.PageRequestDTO;
import com.wybank.dto.PageResponseDTO;
import jakarta.transaction.Transactional;

import static com.wybank.account.domain.QAccountProduct.accountProduct;

@Transactional
public interface AccountProductService {

    AccountProductDTO get(Long accountProductId);
    Long create(AccountProductDTO dto);
    void updateIsDeleted(AccountProductDTO dto);
    void delete(Long accountProductId);
    PageResponseDTO<AccountProductDTO> getList(PageRequestDTO pageRequestDTO);


    default AccountProductDTO entityToDTO(AccountProduct accountProduct) {
        return AccountProductDTO.builder()
                .accountProductId(accountProduct.getAccountProductId())
                .accountType(accountProduct.getAccountType())
                .accountName(accountProduct.getAccountName())
                .accountMemo(accountProduct.getAccountMemo())
                .accountDescription(accountProduct.getAccountDescription())
                .inBankFees(accountProduct.getInBankFees())
                .outBankFees(accountProduct.getOutBankFees())
                .singleTransactionLimit(accountProduct.getSingleTransactionLimit())
                .dailyTransactionLimit(accountProduct.getDailyTransactionLimit())
                .isDeleted(accountProduct.isDeleted())
                .createdAt(accountProduct.getCreatedAt())
                .updatedAt(accountProduct.getUpdatedAt())
                .deletedAt(accountProduct.getDeletedAt())
                .build();
    }

    default AccountProduct dtoToEntity(AccountProductDTO accountProductDTO) {
        return AccountProduct.builder()
                .accountProductId(accountProductDTO.getAccountProductId())
                .accountType(accountProductDTO.getAccountType())
                .accountName(accountProductDTO.getAccountName())
                .accountMemo(accountProductDTO.getAccountMemo())
                .accountDescription(accountProductDTO.getAccountDescription())
                .inBankFees(accountProductDTO.getInBankFees())
                .outBankFees(accountProductDTO.getOutBankFees())
                .singleTransactionLimit(accountProductDTO.getSingleTransactionLimit())
                .dailyTransactionLimit(accountProductDTO.getDailyTransactionLimit())
                .isDeleted(accountProductDTO.isDeleted())
                .createdAt(accountProductDTO.getCreatedAt())
                .updatedAt(accountProductDTO.getUpdatedAt())
                .deletedAt(accountProductDTO.getDeletedAt())
                .build();
    }
}
