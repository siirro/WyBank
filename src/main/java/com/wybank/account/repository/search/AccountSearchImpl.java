package com.wybank.account.repository.search;

import com.querydsl.jpa.JPQLQuery;
import com.wybank.account.domain.Account;
import com.wybank.account.domain.QAccount;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class AccountSearchImpl extends QuerydslRepositorySupport implements AccountSearch{

    public AccountSearchImpl() {
        super(Account.class);
    }

    @Override
    public Page<Account> search1() {
        log.info("Search account");

        QAccount qAccount = QAccount.account;
        JPQLQuery<Account> query = from(qAccount);
        query.where(qAccount.accountName.contains("다시"));
        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        this.getQuerydsl().applyPagination(pageable, query);
        query.fetch(); // 목록 데이터
        query.fetchCount(); // Long 타입
        return null;
    }
}
