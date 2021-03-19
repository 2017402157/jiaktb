package com.jktb.app.controller;

import com.jktb.app.service.IAppLoginService;
import com.jktb.common.constant.Constants;
import com.jktb.common.core.domain.AjaxResult;
import com.jktb.common.core.domain.entity.SysUser;
import com.jktb.common.core.domain.model.LoginBody;
import com.jktb.framework.web.service.TokenService;
import com.jktb.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class AppLoginController {
    @Autowired
    private IAppLoginService appLoginService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult result = AjaxResult.success();
        SysUser user = sysUserService.selectUserByUserName(loginBody.getUsername());
        String token = appLoginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        result.put(Constants.TOKEN, token);
        return result;
    }


}
