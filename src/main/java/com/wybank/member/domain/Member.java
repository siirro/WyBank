package com.wybank.member.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList") // 레이지로딩 이슈
public class Member {
    @Id
    private String userId;
    private String userName;
    private String pw;
    private String phone;
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();
    //    private String login_method; // "일반", "카카오"
    private boolean social;
    private boolean isDeleted;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public void changePw(String pw) {
        this.pw = pw;
    }
    public void changePhone(String phone) {
        this.phone = phone;
    }
    public void changeSocial(boolean social) {
        this.social = social;
    }
    public void changeIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void addRole(MemberRole memberRole) {
        memberRoleList.add(memberRole);
    }
    public void clearRoles() {
        memberRoleList.clear();
    }
}
