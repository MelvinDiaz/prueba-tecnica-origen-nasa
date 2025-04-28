package com.nasa.prueba.aspirante.handlers.response;

import lombok.Data;

@Data
public class GeneralResponse {
    private Object obj;
    private String msg;
    public GeneralResponse(Object obj, String msg) {
        this.obj = obj;
        this.msg = msg;
    }
    protected void setMsg(String msg) {
        this.msg = msg;
    }
    protected void setObj(Object obj) {
        this.obj = obj;
    }
}
