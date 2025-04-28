package com.nasa.prueba.aspirante.handlers;

import com.nasa.prueba.aspirante.handlers.response.GeneralResponse;
import com.nasa.prueba.aspirante.handlers.response.GeneralResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
    private final GeneralResponseBuilder generalResponse;
    @ExceptionHandler(Exception.class)
    // Handle all exceptions
    public ResponseEntity<GeneralResponse> handleGeneral(Exception ex) {
        log.error("Error occurred: type=[{}], message=[{}], trace=[{}]",
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                ex.getStackTrace());
        return generalResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
