package com.example.kehou.common.exception;

/**
 * @author ShuangLian
 * @date 2021/11/24 10:26
 */
public class BaseException extends RuntimeException {
    private String msg;

    public BaseException(String msg) {
        this.msg = msg;
    }

}
