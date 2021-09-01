package dev.ritam.hashed_it.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnknownHashTypeException extends RuntimeException {
    public UnknownHashTypeException(String msg) {
        super(msg);
    }
}
