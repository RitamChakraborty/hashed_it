package dev.ritam.hashed_it.controller.ui;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = Controller.class, basePackageClasses = HomeController.class, basePackages = "dev.ritam.hashed_id.controller.ui")
public class ControllerExceptionHandler {
    @ExceptionHandler(RequestNotPermitted.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public String rateLimited() {
        return "rate-limited";
    }
}
