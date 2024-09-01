package com.wybank.loan.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import com.wybank.loan.counsel.domain.Counsel;
import com.wybank.loan.counsel.dto.CounselDTO;
import com.wybank.loan.counsel.repository.CounselRepository;
import com.wybank.loan.counsel.service.CounselServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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

}
