package com.wybank.domain;

import java.time.LocalDateTime;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String phone;
    private String login_method; // "일반", "카카오"
    private String role; // "USER", "ADMIN"
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
