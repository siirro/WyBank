package com.wybank.account.repository.search;

import com.wybank.account.domain.Account;
import org.springframework.data.domain.Page;

public interface AccountSearch {
    Page<Account> search1();
}
