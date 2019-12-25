package com.linkpets.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("api接口通用返回对象")
public class ApiResult {
    /**
     * 错误码，对应{@link ErrorCode}，表示一种错误类型 如果是成功，则code为200
     */
    @ApiModelProperty(value = "返回码", dataType = "int")
    private int code;
    /**
     * 对错误的具体解释
     */
    @ApiModelProperty(value = "错误信息", dataType = "String")
    private String message;

    /**
     * 返回的结果包装在data中，data可以是单个对象
     */
    @ApiModelProperty(value = "数据", dataType = "Object")
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResult(int code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }


    public static ApiResult success() {
        return new ApiResult(ApiResultCode.SUCCESS.getCode(), ApiResultCode.SUCCESS.getMsg(), "");
    }

    // 忽略getter和setter，以及构造函数
    public static ApiResult valueOf(Object body) {
        return new ApiResult(ApiResultCode.SUCCESS.getCode(), ApiResultCode.SUCCESS.getMsg(), body);
    }

    public static ApiResult errorOf(ApiResultCode jsonParseError, String msg) {
        return new ApiResult(jsonParseError.getCode(), "".equals(msg) ? jsonParseError.getMsg() : msg, null);
    }

    public static ApiResult errorOf(ApiResultCode jsonParseError) {
        return new ApiResult(jsonParseError.getCode(), jsonParseError.getMsg(), null);
    }

    public static ApiResult errorOf(String message) {
        return new ApiResult(500, message, null);
    }
}
