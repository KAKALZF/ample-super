package com.ample16.springcloud.consumer.common;

public class Response<T> {
    public String des;
    public int code;
    public T data;


    public Response() {
    }

    public static Response successResposne() {
        return new Response().setCode(0).setDes("success");
    }

    public String getDes() {
        return des;
    }

    public Response setDes(String des) {
        this.des = des;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }
}
