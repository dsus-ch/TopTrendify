package com.thehanged.server.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thehanged.model.user.pojos.AppUserFollow;
import com.thehanged.server.user.mapper.AppUserFollowMapper;
import com.thehanged.server.user.service.IAppUserFollowService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP用户关注信息表 服务实现类
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Service
public class AppUserFollowServiceImpl extends ServiceImpl<AppUserFollowMapper, AppUserFollow>
        implements IAppUserFollowService {

}
