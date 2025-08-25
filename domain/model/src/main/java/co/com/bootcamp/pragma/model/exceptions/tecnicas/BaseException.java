package co.com.bootcamp.pragma.model.exceptions.tecnicas;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final int httpStatusCode;

    public BaseException(String message, int httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }
}