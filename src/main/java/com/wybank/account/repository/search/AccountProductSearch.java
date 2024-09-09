package com.wybank.account.repository.search;

import com.wybank.account.domain.Account;
import com.wybank.account.domain.AccountProduct;
import com.wybank.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface AccountProductSearch {
    Page<AccountProduct> searchAccountProductList(PageRequestDTO pageRequestDTO);
}
