package com.thehanged.server.user.controller.v1;

import com.thehanged.model.common.dtos.ResponseResult;
import com.thehanged.model.user.dtos.LoginDto;
import com.thehanged.server.user.service.impl.AppUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * APP端用户登录
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "APP端用户登录", tags = "app_user")
public class AppUserLoginController {
    @Autowired
    AppUserServiceImpl appUserService;

    @PostMapping("/login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto loginDto){
        return appUserService.login(loginDto);
    }
}
