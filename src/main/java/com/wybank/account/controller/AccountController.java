package com.wybank.account.controller;

import com.wybank.account.dto.AccountDTO;
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

    @GetMapping("/info/{accountId}")
    public AccountDTO get(@PathVariable("accountId") Long accountId) {
        return accountService.get(accountId);
    }

    @GetMapping("/list")
    public PageResponseDTO<AccountDTO> list(PageRequestDTO pageRequestDTO) {
        return accountService.getList(pageRequestDTO);
    }

    @PostMapping("/create")
    public Map<String, Long> create(@RequestBody AccountDTO dto) {
        Long accountId = accountService.create(dto);
        return Map.of("ACCOUNT_ID", accountId);
    }

    @PutMapping("/update/memo/{accountId}")
    public Map<String, String> update(@PathVariable("accountId") Long accountId, @RequestBody AccountDTO dto) {
        dto.setAccountId(accountId);
        accountService.updateMemo(dto);

        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/delete/{accountId}")
    public Map<String, String> delete(@PathVariable("accountId") Long accountId) {
        accountService.delete(accountId);

        return Map.of("RESULT", "SUCCESS");
    }


}
