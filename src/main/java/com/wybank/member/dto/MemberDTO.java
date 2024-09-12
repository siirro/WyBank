package com.wybank.member.dto;

import com.wybank.member.domain.MemberRole;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MemberDTO extends User {

    private String userId, userName, pw, phone;
    private boolean social, isDeleted;
    private LocalDateTime createdAt, updatedAt, deletedAt;

    private List<String> roleNames = new ArrayList<>();

    public MemberDTO(String userId, String username, String pw, String phone, boolean social, boolean isDeleted, List<String> roleNames, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        super(
                userId,
                pw,
                roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_"+str)).collect(Collectors.toList())
        );
        this.userId = userId;
        this.userName = username;
        this.pw = pw;
        this.phone = phone;
        this.social = social;
        this.isDeleted = isDeleted;
        this.roleNames = roleNames;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Map<String, Object> getClaims() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("userId", userId);
        dataMap.put("userName", userName);
        dataMap.put("pw", pw);
        dataMap.put("roleNames", roleNames);
        dataMap.put("createdAt", createdAt);
        dataMap.put("updatedAt", updatedAt);
        dataMap.put("deletedAt", deletedAt);
        dataMap.put("social", social);
        dataMap.put("isDeleted", isDeleted);
        return dataMap;
    }
}
