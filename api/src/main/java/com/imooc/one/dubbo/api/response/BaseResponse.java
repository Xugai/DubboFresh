package com.imooc.one.dubbo.api.response;

import com.imooc.one.dubbo.api.enums.ResponseCode;

import java.io.Serializable;

/**
 * Created by rabbit on 2019/6/1.
 */
public class BaseResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private BaseResponse(){}

    private BaseResponse(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private BaseResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private BaseResponse(int code, T data){
        this.code = code;
        this.data = data;
    }

    public static <T> BaseResponse<T> createBySuccess(){
        return new BaseResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static <T> BaseResponse<T> createBySuccessMessage(String message){
        return new BaseResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> BaseResponse<T> createBySuccess(T data){
        return new BaseResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static <T> BaseResponse<T> createBySuccess(String message, T data){
        return new BaseResponse<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> BaseResponse<T> createByError(){
        return new BaseResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg());
    }

    public static <T> BaseResponse<T> createByErrorMessage(String message){
        return new BaseResponse<T>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> BaseResponse<T> createByErrorCodeAndErrorMessage(int code, String message){
        return new BaseResponse<T>(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
