package com.wybank.account.service;

import com.wybank.account.domain.Account;
import com.wybank.account.domain.AccountProduct;
import com.wybank.account.dto.AccountProductDTO;
import com.wybank.account.repository.AccountProductRepository;
import com.wybank.dto.PageRequestDTO;
import com.wybank.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountProductServiceImpl implements AccountProductService{

    private final AccountProductRepository accountProductRepository;

    @Override
    public AccountProductDTO get(Long accountProductId) {

        return null;
    }

    @Override
    public Long create(AccountProductDTO dto) {
        AccountProduct accountProduct = dtoToEntity(dto);
        AccountProduct result = accountProductRepository.save(accountProduct);
        return result.getAccountProductId();
    }

    @Override
    public void updateIsDeleted(AccountProductDTO dto) {

    }

    @Override
    public void delete(Long accountProductId) {

    }

    @Override
    public PageResponseDTO<AccountProductDTO> getList(PageRequestDTO pageRequestDTO) {
        Page<AccountProduct> result = accountProductRepository.searchAccountProductList(pageRequestDTO);
        List<AccountProductDTO> dtoList = result.get().map(accountProduct -> entityToDTO(accountProduct)).collect(Collectors.toList());

        PageResponseDTO<AccountProductDTO> pageResponseDTO = PageResponseDTO.<AccountProductDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(result.getTotalElements())
                .build();

        log.info("???????");
        log.info(pageRequestDTO);
        return pageResponseDTO;
    }
}
