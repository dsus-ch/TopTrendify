package com.thehanged.server.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thehanged.model.user.pojos.AppUserFan;
import com.thehanged.server.user.mapper.AppUserFanMapper;
import com.thehanged.server.user.service.IAppUserFanService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP用户粉丝信息表 服务实现类
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Service
public class AppUserFanServiceImpl extends ServiceImpl<AppUserFanMapper, AppUserFan>
        implements IAppUserFanService {

}
