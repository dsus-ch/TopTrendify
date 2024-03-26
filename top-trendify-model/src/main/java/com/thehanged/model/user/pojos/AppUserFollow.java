package com.thehanged.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * APP用户关注信息表
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Data
@TableName("app_user_follow")
public class AppUserFollow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 关注作者ID
     */
    private Integer followId;

    /**
     * 粉丝昵称
     */
    private String followName;

    /**
     * 关注度   0 偶尔感兴趣   1 一般   2 经常   3 高度
     */
    private Integer level;

    /**
     * 是否动态通知
     */
    private Integer isNotice;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;


}
