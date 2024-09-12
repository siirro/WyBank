package com.wybank.loan.counsel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCounsel is a Querydsl query type for Counsel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCounsel extends EntityPathBase<Counsel> {

    private static final long serialVersionUID = 1178083391L;

    public static final QCounsel counsel = new QCounsel("counsel");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final DateTimePath<java.time.LocalDateTime> appliedAt = createDateTime("appliedAt", java.time.LocalDateTime.class);

    public final StringPath cellPhone = createString("cellPhone");

    public final NumberPath<Long> counselId = createNumber("counselId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath memo = createString("memo");

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath zipCode = createString("zipCode");

    public QCounsel(String variable) {
        super(Counsel.class, forVariable(variable));
    }

    public QCounsel(Path<? extends Counsel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCounsel(PathMetadata metadata) {
        super(Counsel.class, metadata);
    }

}

