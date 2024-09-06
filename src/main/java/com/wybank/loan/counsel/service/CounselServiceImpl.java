package com.wybank.loan.counsel.service;

import com.wybank.loan.counsel.domain.Counsel;
import com.wybank.loan.counsel.dto.CounselDTO;
import com.wybank.loan.counsel.repository.CounselRepository;
import com.wybank.exception.BaseException;
import com.wybank.exception.ResultType;
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

    // 상담 수정
    @Override
    public CounselDTO.Response update(Long counselId, CounselDTO.Request request) {

        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.ARTICLE_NOT_FOUND));
        //TODO 정책에 따라서 validation 처리 필요함
        counsel.modifyCounsel(request);

        counselRepository.save(counsel);

        return modelMapper.map(counsel, CounselDTO.Response.class);
    }

    // 상담 삭제
    @Override
    public void delete(Long counselId) {
        // 대출 리스트에서 버튼 선택 -> 삭헤한다. -> 있는것만 조회 , 삭제하기 때문에 게시글이 있는지없는지 확인 할 필요 없음
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.ARTICLE_NOT_FOUND));

        counsel.setIsDeleted(true);

        counselRepository.save(counsel);

    }
}
