package com.wybank.account.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountProduct is a Querydsl query type for AccountProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountProduct extends EntityPathBase<AccountProduct> {

    private static final long serialVersionUID = -1791844856L;

    public static final QAccountProduct accountProduct = new QAccountProduct("accountProduct");

    public final StringPath accountName = createString("accountName");

    public final NumberPath<Long> accountProductId = createNumber("accountProductId", Long.class);

    public final StringPath accountType = createString("accountType");

    public final NumberPath<Long> dailyTransactionLimit = createNumber("dailyTransactionLimit", Long.class);

    public final NumberPath<Long> inBankFees = createNumber("inBankFees", Long.class);

    public final NumberPath<Long> outBankFees = createNumber("outBankFees", Long.class);

    public final NumberPath<Long> singleTransactionLimit = createNumber("singleTransactionLimit", Long.class);

    public QAccountProduct(String variable) {
        super(AccountProduct.class, forVariable(variable));
    }

    public QAccountProduct(Path<? extends AccountProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountProduct(PathMetadata metadata) {
        super(AccountProduct.class, metadata);
    }

}

