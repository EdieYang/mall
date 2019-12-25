package com.linkpets.config;

import com.linkpets.result.ApiResult;
import com.linkpets.result.ApiResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Edie
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ApiResult handlerException(RuntimeException exception) {
        exception.printStackTrace();
        log.error(exception.toString());
        switch (exception.getMessage()) {
            case "40001":
                return ApiResult.errorOf(ApiResultCode.VALID_USER_ACCOUNT);
            case "40003":
                return ApiResult.errorOf(ApiResultCode.VALID_USER_LOGIN_TOKEN);
            default:
                break;
        }
        return ApiResult.errorOf(exception.getMessage());
    }

}
