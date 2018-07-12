package com.miss.module.springmvc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.http.HttpHeaders;

@JSONType(ignores="headers")
public class RestResponseBean {
    @JSONField(name = "code")
    private String errorCode;

    @JSONField(name = "msg")
    private String errorMessage;

    //private String exception;
    @JSONField(name = "data")
    private Object data;

    private HttpHeaders headers;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteNullStringAsEmpty);
    }
}
