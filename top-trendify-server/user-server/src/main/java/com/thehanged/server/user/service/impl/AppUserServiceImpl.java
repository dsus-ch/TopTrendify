package com.thehanged.server.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thehanged.model.common.dtos.ResponseResult;
import com.thehanged.model.common.enums.AppHttpCodeEnum;
import com.thehanged.model.user.dtos.LoginDto;
import com.thehanged.model.user.pojos.AppUser;
import com.thehanged.server.user.mapper.AppUserMapper;
import com.thehanged.server.user.service.IAppUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thehanged.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * APP用户信息表 服务实现类
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Service
@Transactional
@Slf4j
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser>
        implements IAppUserService {
    /**
     * App端用户登录
     *
     * @param loginDto
     * @return ResponseResult
     */
    @Override
    public ResponseResult login(LoginDto loginDto) {
        if (Objects.isNull(loginDto)){
            // throw TODO
        }
        // 正常登录
        if(StringUtils.isNoneBlank(loginDto.getPassword()) && StringUtils.isNoneBlank(loginDto.getPhone())){
            AppUser appUser = getOne(Wrappers.<AppUser>lambdaQuery().eq(AppUser::getPhone, loginDto.getPhone()));
            if(Objects.isNull(appUser)){
                return ResponseResult.errorResult(AppHttpCodeEnum.APP_USER_DATA_NOT_EXIST);
            }

            if(appUser.getPassword().equals(
                    DigestUtils.md5Hex((loginDto.getPassword() + appUser.getSalt()).getBytes())
            )){
                // 校验成功需要生成jwt
                String token = AppJwtUtil.getToken(appUser.getId().longValue());
                Map<String, Object> map = new HashMap<>();
                map.put("token", token);
                // AppUser中不用返回的部分
                appUser.setSalt("");
                appUser.setPassword("");
                map.put("user", appUser);
                return ResponseResult.okResult(map);
            }else {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }else{ // 游客模式
            String token = AppJwtUtil.getToken((long)0);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return ResponseResult.okResult(map);
        }
    }
}
