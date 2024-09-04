package com.wybank.account.repository.search;

import com.querydsl.jpa.JPQLQuery;
import com.wybank.account.domain.Account;
import com.wybank.account.domain.QAccount;
import com.wybank.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class AccountSearchImpl extends QuerydslRepositorySupport implements AccountSearch{

    public AccountSearchImpl() {
        super(Account.class);
    }

    @Override
    public Page<Account> search1(PageRequestDTO pageRequestDTO) {
        log.info("Search account");

        QAccount qAccount = QAccount.account;
        JPQLQuery<Account> query = from(qAccount);

//        query.where(qAccount.accountName.contains("다시"));

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage()-1,
                pageRequestDTO.getSize(),
                Sort.by("createdAt").descending());
        this.getQuerydsl().applyPagination(pageable, query);
        List<Account> list = query.fetch(); // 목록 데이터
        Long total = query.fetchCount(); // Long 타입
        return new PageImpl<>(list, pageable, total);
    }
}
