    package com.example.kehou.domain.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

    /**
 * @author ShuangLian
 * @date 2021/11/23 11:05
 */
@Data
public class LoginBody {
    @NotBlank(message = "姓名不为空")
    private String username;
    private String password;
}
