package com.nasa.prueba.aspirante.handlers.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GeneralResponseBuilder {
    private GeneralResponse generalResponse;
    private HttpStatus httpStatus;
    private HttpHeaders headers;

    public  GeneralResponseBuilder setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }
    public GeneralResponseBuilder setMessage(String message) {
        this.generalResponse.setMsg(message);
        return this;
    }
    public GeneralResponseBuilder setObj(Object obj) {
        this.generalResponse.setObj(obj);
        return this;
    }

    public GeneralResponseBuilder setHeaders(String name, String value) {
        this.headers.add(name, value);
        return this;
    }

    private void reset() {
        this.generalResponse = new GeneralResponse(null, null);
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.headers = new HttpHeaders();
    }

    public ResponseEntity<GeneralResponse> build() {
        ResponseEntity<GeneralResponse> res = new ResponseEntity<GeneralResponse>(generalResponse, headers,httpStatus);
        reset();
        return res;
    }

    public GeneralResponseBuilder() {
        this.generalResponse = new GeneralResponse(null, null);
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.headers = new HttpHeaders();
    }
}
