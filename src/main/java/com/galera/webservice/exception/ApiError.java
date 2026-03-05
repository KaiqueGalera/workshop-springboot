package com.galera.webservice.exception;

public record ApiError(
        int status,
        String message,
        String path
) {
}
