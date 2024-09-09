package com.wybank.account.repository.search;

import com.querydsl.jpa.JPQLQuery;
import com.wybank.account.domain.Account;
import com.wybank.account.domain.AccountProduct;
import com.wybank.account.domain.QAccountProduct;
import com.wybank.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class AccountProductSearchImpl extends QuerydslRepositorySupport implements AccountProductSearch{

    public AccountProductSearchImpl() {
        super(AccountProduct.class);
    }

    @Override
    public Page<AccountProduct> searchAccountProductList(PageRequestDTO pageRequestDTO) {
        QAccountProduct qAccountProduct = QAccountProduct.accountProduct;
        JPQLQuery<AccountProduct> query = from(qAccountProduct);
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage()-1,
                pageRequestDTO.getSize(),
                Sort.by("createdAt").descending());
        this.getQuerydsl().applyPagination(pageable, query);
        List<AccountProduct> list = query.fetch();
        Long total = query.fetchCount();
        return new PageImpl<>(list, pageable, total);
    }
}
