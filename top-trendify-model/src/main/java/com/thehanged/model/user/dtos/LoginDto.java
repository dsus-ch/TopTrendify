package com.thehanged.model.user.dtos;

import lombok.Data;

@Data
public class LoginDto {
    private String phone;
    private String password;
}
