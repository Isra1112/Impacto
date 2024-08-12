package com.example.impacto.impactopreinterv.utils;

import java.util.List;

public class ResponseBuilder<T> {
    public static <T> T buildResponse(int code, String message, Object data) {
        return (T) BaseResponse.builder()
                .code(code)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> T buildResponse(int code, String message, Object data, List<String> errorList) {
        return (T) BaseResponse.builder()
                .code(code)
                .data(data)
                .message(message)
                .errorList(errorList)
                .build();
    }

    public static <T> T buildResponse(int code, String message, Object data, List<String> errorList, Integer pageNumber, Integer pageSize, Integer totalPage, Long totalData) {
        return (T) BaseResponse.builder()
                .code(code)
                .data(data)
                .message(message)
                .errorList(errorList)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .totalPage(totalPage)
                .totalData(totalData)
                .build();
    }
}
