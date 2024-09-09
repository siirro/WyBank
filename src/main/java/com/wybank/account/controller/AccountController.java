package com.wybank.account.controller;

import com.wybank.account.dto.AccountDTO;
import com.wybank.account.dto.AccountProductDTO;
import com.wybank.account.service.AccountProductService;
import com.wybank.account.service.AccountService;
import com.wybank.dto.PageRequestDTO;
import com.wybank.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountProductService accountProductService;

    @GetMapping("/info/{accountId}")
    public AccountDTO getAccountInfo(@PathVariable("accountId") Long accountId) {
        return accountService.get(accountId);
    }

    @GetMapping("/list")
    public PageResponseDTO<AccountDTO> getAccountList(PageRequestDTO pageRequestDTO) {
        return accountService.getList(pageRequestDTO);
    }

    @PostMapping("/create")
    public Map<String, Long> createAccount(@RequestBody AccountDTO dto) {
        Long accountId = accountService.create(dto);
        return Map.of("ACCOUNT_ID", accountId);
    }

    @PutMapping("/update/memo/{accountId}")
    public Map<String, String> updateAccountMemo(@PathVariable("accountId") Long accountId, @RequestBody AccountDTO dto) {
        dto.setAccountId(accountId);
        accountService.updateMemo(dto);

        return Map.of("RESULT", "SUCCESS");
    }

    // Account 완전 삭제 (사용X)
    @DeleteMapping("/delete/{accountId}")
    public Map<String, String> deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.delete(accountId);

        return Map.of("RESULT", "SUCCESS");
    }

    // 계좌 상품 리스트
    @GetMapping("product")
    public PageResponseDTO<AccountProductDTO> getProductList(PageRequestDTO pageRequestDTO) {
        log.info("getAccountProductList");
        return accountProductService.getList(pageRequestDTO);
    }

    @PostMapping("/product/create")
    public Map<String, Long> createProduct(@RequestBody AccountProductDTO dto) {
        Long accountProductId = accountProductService.create(dto);
        return Map.of("ACCOUNT_PRODUCT_ID", accountProductId);
    }

}
