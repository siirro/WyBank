package com.wybank.account.repository;

import com.wybank.account.domain.AccountProduct;
import com.wybank.account.repository.search.AccountProductSearch;
import com.wybank.account.repository.search.AccountSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountProductRepository extends JpaRepository<AccountProduct, Long>, AccountProductSearch {
}
