package com.example.movie_tickets.Common.Result;

import com.example.movie_tickets.Common.ResultCode.ResultCodeInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Api<T>{
    private Result result;
    @Valid
    private T body;

    public static <T> Api<T> SUCCESS(
            ResultCodeInterface resultCodeInterface, T data
    ) {
        var api = new Api<T>();
        api.result = Result.SUCCESS(resultCodeInterface);
        api.body = data;
        return api;
    }

    public static Api<Object> ERROR(
            ResultCodeInterface resultCodeInterface
    ) {
        var api = new Api<Object>();
        api.result = Result.ERROR(resultCodeInterface);
        return api;
    }

    public static Api<Object> ERROR(
            ResultCodeInterface resultCodeInterface, String description
    ) {
        var api = new Api<Object>();
        api.result = Result.ERROR(resultCodeInterface, description);
        return api;
    }

    public static Api<Object> ERROR(
            String message
    ) {
        return new Api<>(null, message);
    }
}
