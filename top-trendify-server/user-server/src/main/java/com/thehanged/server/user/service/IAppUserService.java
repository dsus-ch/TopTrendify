package com.thehanged.server.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thehanged.model.common.dtos.ResponseResult;
import com.thehanged.model.user.dtos.LoginDto;
import com.thehanged.model.user.pojos.AppUser;

/**
 * <p>
 * APP用户信息表 服务类
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
public interface IAppUserService extends IService<AppUser> {

    /**
     * App端用户登录
     *
     * @param loginDto
     * @return ResponseResult
     */
    ResponseResult login(LoginDto loginDto);
}
