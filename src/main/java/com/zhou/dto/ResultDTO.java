package com.zhou.dto;

/**
 * Created by ZhouXiang on 2017/6/28 16:17.
 */
public class ResultDTO {
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    private String code;
    private String message;
    private String type;
    private Object data;

    public ResultDTO() {
    }

    public ResultDTO(String code, String message, String type, Object data) {
        this.code = code;
        this.message = message;
        this.type = type;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
