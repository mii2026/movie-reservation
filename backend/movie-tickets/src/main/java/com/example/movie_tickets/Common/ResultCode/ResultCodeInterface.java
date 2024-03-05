package com.example.movie_tickets.Common.ResultCode;

public interface ResultCodeInterface {
    Integer getHttpStatusCode();
    Integer getResultCode();
    String getDescription();
}
