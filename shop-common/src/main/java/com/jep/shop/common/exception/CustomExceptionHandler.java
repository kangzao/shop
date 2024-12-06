package com.jep.shop.common.exception;

import com.jep.shop.common.util.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author enping
 * @date 2024/9/28 16:57
 * 全局异常处理：
 * ControllerAdvice配合ExceptionHandler使用。 当将异常抛到controller时,可以对异常进行统一处理,规定返回的json格式或是跳转到一个错误页面
 **/
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        //是不是自定义异常
        if (e instanceof BizException) {

            BizException bizException = (BizException) e;
            log.error("[业务异常 {}]", e);

            return JsonData.buildCodeAndMsg(bizException.getCode(), bizException.getMsg());

        } else {

            log.error("[系统异常 {}]", e);
            return JsonData.buildError("全局异常，未知错误");
        }

    }

}
