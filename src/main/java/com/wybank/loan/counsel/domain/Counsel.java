package com.wybank.loan.counsel.domain;

import com.wybank.loan.counsel.dto.CounselDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted=false")
//public class Counsel extends BaseEntity {
public class Counsel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long counselId;

    @Column(nullable = false, columnDefinition = "datetime COMMENT '신청일자'")
    private LocalDateTime appliedAt;

    @Column(nullable = false, columnDefinition = "varchar(10) COMMENT '상담요청자'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(23) COMMENT '전화번호'")
    private String cellPhone;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '상담요청자 이메일'")
    private String email;

    @Column(columnDefinition = "text DEFAULT NULL COMMENT '상담메모'")
    private String memo;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '상담요청자 주소'")
    private String address;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '상담요청자 상세주소'")
    private String addressDetail;

    @Column(columnDefinition = "varchar(5) DEFAULT NULL COMMENT '우편번호'")
    private String zipCode;

//    @Column(nullable = false, columnDefinition = "datetime COMMENT '생성일자'")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ColumnDefault("false")
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean isDeleted ;

    public void modifyCounsel(CounselDTO.Request request) {
        this.name = request.getName();
        this.cellPhone = request.getCellPhone();
        this.email = request.getEmail();
        this.memo = request.getMemo();
        this.address = request.getAddress();
        this.addressDetail = request.getAddressDetail();
        this.zipCode = request.getZipCode();
    }
}
