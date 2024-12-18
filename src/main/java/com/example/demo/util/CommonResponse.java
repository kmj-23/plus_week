package com.example.demo.util;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    /**
     * Response 메세지.
     */
    private final String message;
    /**
     * Response 데이터.
     */
    private final T data;

    /**
     * 생성자.
     *
     * @param message Response 메세지
     * @param data    Response 데이터
     */
    public CommonResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    /**
     * 생성자. {@code data} 필드는 {@code null}로 초기화 합니다.
     *
     * @param message Response 메세지
     */
    public CommonResponse(String message) {
        this(message, null);
    }
}
