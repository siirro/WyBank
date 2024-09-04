package com.wybank.account.repository;

import com.wybank.account.domain.Account;
import com.wybank.account.repository.search.AccountSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountSearch {
}
