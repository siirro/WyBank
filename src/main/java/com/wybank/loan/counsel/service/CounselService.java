package com.wybank.loan.counsel.service;

import com.wybank.loan.counsel.dto.CounselDTO;

public interface CounselService {

    CounselDTO.Response create(CounselDTO.Request request); // 상담요청

    CounselDTO.Response get(Long counselId); // 상담조회
}
