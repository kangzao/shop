package com.jep.shop.common.exception;

import com.jep.shop.common.enums.BizCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author enping
 * @date 2024/9/28 16:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    private int code;
    private String msg;

    public BizException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }


}
