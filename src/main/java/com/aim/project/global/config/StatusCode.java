package com.aim.project.global.config;

import lombok.Getter;

@Getter
public enum StatusCode {

    SUCCESS("E000","성공",200),
    CALL_API("E001","API 요청 완료",200),
    API_LODING("E002","1분뒤 다시 시도해주세요.",200);

    private final String code;
    private final String message;
    private final int status;

    StatusCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
