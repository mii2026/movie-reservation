package com.example.movie_tickets.Common.Result;


import com.example.movie_tickets.Common.ResultCode.ResultCodeInterface;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    private Integer resultCode;
    private String resultMessage;
    private String resultDescription;

    public static Result SUCCESS(ResultCodeInterface resultCode){
        return Result.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getDescription())
                .resultDescription("성공")
                .build();
    }

    public static Result Error(ResultCodeInterface resultCode){
        return Result.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getDescription())
                .resultDescription("실패")
                .build();
    }

    public static Result Error(ResultCodeInterface resultCode, String description){
        return Result.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getDescription())
                .resultDescription(description)
                .build();
    }
}
