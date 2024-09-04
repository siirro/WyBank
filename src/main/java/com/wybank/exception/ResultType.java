package com.wybank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultType {

    SUCCESS("0000", "success"),

    SYSTEM_ERROR("9000", "system error"),

    ARTICLE_NOT_FOUND("0001", "article not found"),;

    private final String code;
    private final String desc;
}