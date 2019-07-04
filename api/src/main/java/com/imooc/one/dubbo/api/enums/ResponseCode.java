package com.imooc.one.dubbo.api.enums;

/**
 * Created by rabbit on 2019/6/1.
 */
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    INVALID_PARAM(401, "INVALID_PARAM"),
    NON_ENOUGH_STOCK(402, "NO_ENOUGH_STOCK");


    private int code;
    private String msg;

    ResponseCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
