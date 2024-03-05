package com.example.movie_tickets.Common.ResultCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResultCode implements ResultCodeInterface{
    OK(200, 200, "Success"),
    CREATED(201, 201, "Created"),
    BAD_REQUEST(400, 400, "Bad Request"),
    UNAUTHORIZED(401, 401, "Unauthorized"),
    FORBIDDEN(403, 403, "Forbidden"),
    SERVER_ERRPR(500, 500, "Invalid Server Error");

    private final Integer httpStatusCode;
    private final Integer resultCode;
    private final String description;
}
