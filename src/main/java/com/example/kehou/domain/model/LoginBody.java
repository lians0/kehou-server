package com.example.kehou.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author ShuangLian
 * @date 2021/11/23 11:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBody {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
