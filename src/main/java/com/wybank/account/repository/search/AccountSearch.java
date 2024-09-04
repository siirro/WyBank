package com.wybank.account.repository.search;

import com.wybank.account.domain.Account;
import com.wybank.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface AccountSearch {
    Page<Account> search1(PageRequestDTO pageRequestDTO);
}
