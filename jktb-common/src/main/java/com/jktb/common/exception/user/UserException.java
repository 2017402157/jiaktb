package com.jktb.common.exception.user;

import com.jktb.common.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author jktb
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
