package com.wybank.loan.counsel.service;

import com.wybank.loan.counsel.domain.Counsel;
import com.wybank.loan.counsel.dto.CounselDTO;
import com.wybank.loan.counsel.repository.CounselRepository;
import com.wybank.loan.exception.BaseException;
import com.wybank.loan.exception.ResultType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    // 실제 db에 insert하기위한 작업
    private final CounselRepository counselRepository;
    private final ModelMapper modelMapper;

    @Override
    public CounselDTO.Response create(CounselDTO.Request request) {

        Counsel counsel = modelMapper.map(request, Counsel.class); // 요청한 값에서 엔티티값 셋팅
        counsel.setAppliedAt(LocalDateTime.now());

        Counsel created = counselRepository.save(counsel);
        return modelMapper.map(created, CounselDTO.Response.class);
    }

    // 상담조회
    @Override
    public CounselDTO.Response get(Long counselId) {

       Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

       return modelMapper.map(counsel, CounselDTO.Response.class);
    }
}
