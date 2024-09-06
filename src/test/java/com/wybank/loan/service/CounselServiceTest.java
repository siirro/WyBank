package com.wybank.loan.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import com.wybank.loan.counsel.domain.Counsel;
import com.wybank.loan.counsel.dto.CounselDTO;
import com.wybank.loan.counsel.repository.CounselRepository;
import com.wybank.loan.counsel.service.CounselServiceImpl;
import com.wybank.exception.BaseException;
import com.wybank.exception.ResultType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

    @InjectMocks
    CounselServiceImpl counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy // util성이기 때문에 mock처리 안함
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel(){
        Counsel entity = Counsel.builder()
                .name("jdh")
                .cellPhone("010-555-5555")
                .email("abc@email.com")
                .memo("상담받고싶어요")
                .zipCode("15875")
                .address("경기도 군포시 당동")
                .addressDetail("주공아파트")
                .build();

        CounselDTO.Request request = CounselDTO.Request.builder()
                .name("jdh")
                .cellPhone("010-555-5555")
                .email("abc@email.com")
                .memo("상담받고싶어요")
                .zipCode("15875")
                .address("경기도 군포시 당동")
                .addressDetail("주공아파트")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

        CounselDTO.Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());

    }

    @Test
    void Should_ReturnResponseOfExistCounselEntity_When_RequestExistCounselId(){

        Long findId = 1L;

        Counsel entity = Counsel.builder()
                .counselId(1L)
                .build();

        when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        CounselDTO.Response actual = counselService.get(findId);

        assertThat(actual.getCounselId()).isSameAs(findId);
    }
    // 존재하지 않는 id에 대한 테스트
    @Test
    void Should_throwException_When_RequestNotExistCounselId(){

        Long findId = 2L;

        when(counselRepository.findById(findId)).thenThrow(new BaseException(ResultType.SYSTEM_ERROR));

        Assertions.assertThrows(BaseException.class, () -> counselService.get(findId));
    }

    @Test
    void Should_ReturnResponseOfUpdatedCounselEntity_When_GetCounselIdAndArticle(){

        Long findId = 1L;

        // db에서 가져온 entity
        Counsel entity = Counsel.builder()
                .counselId(1L)
                .name("정다희")
                .build();
        // 수정하도록 요청이 들어온 값
        CounselDTO.Request request =  CounselDTO.Request.builder()
                .name("정다쿠")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);// mock 처리
        when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        CounselDTO.Response actual = counselService.update(findId,request);

        assertThat(actual.getCounselId()).isSameAs(findId);
        assertThat(actual.getName()).isSameAs(request.getName());
    }

    @Test
    void Should_DeleteCounselEntity_When_DeleteCounselId(){
        Long targetId = 1L;

        Counsel entity = Counsel.builder()
                .counselId(1L)
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);// mock 처리
        when(counselRepository.findById(targetId)).thenReturn(Optional.ofNullable(entity));

        counselService.delete(targetId);

        assertThat(entity.getIsDeleted()).isSameAs(false);

    }
}
