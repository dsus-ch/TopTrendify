package com.thehanged.server.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thehanged.model.user.pojos.AppUserRealname;
import com.thehanged.server.user.mapper.AppUserRealnameMapper;
import com.thehanged.server.user.service.IAppUserRealnameService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP实名认证信息表 服务实现类
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Service
public class AppUserRealnameServiceImpl extends ServiceImpl<AppUserRealnameMapper, AppUserRealname>
        implements IAppUserRealnameService {

}
