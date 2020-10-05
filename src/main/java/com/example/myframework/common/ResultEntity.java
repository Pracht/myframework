package com.example.myframework.common;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.io.Serializable;

/**
 * @author lm
 * @date 2019/4/20 12:23
 * @Description TODO
 **/
@Slf4j
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ResultEntity<T> implements Serializable {

    private int code = CommonConstants.SUCCESS;

    private String msg = "success";

    private T data;

    private JSONObject other;

    public ResultEntity() {
        super();
    }

    public ResultEntity(T data, JSONObject other) {
        super();
        this.other = other;
        this.data = data;

    }
    public ResultEntity(T data) {
        super();
        this.data = data;
    }

    public ResultEntity(int code, String msg, T data) {
        super();
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResultEntity(String msg) {
        super();
        this.msg = msg;
        this.code = CommonConstants.FAIL;
    }

    public ResultEntity(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }

    public ResultEntity(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public static <T> ResultEntity<T> ok() {
        return restResult(null, CommonConstants.SUCCESS, "success");
    }

    public static <T> ResultEntity<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS, "success");
    }

    public static <T> ResultEntity<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> ResultEntity<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> ResultEntity<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> ResultEntity<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> ResultEntity<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    private static <T> ResultEntity<T> restResult(T data, int code, String msg) {
        ResultEntity<T> apiResult = new ResultEntity<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
