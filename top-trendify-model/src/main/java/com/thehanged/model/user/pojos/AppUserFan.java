package com.thehanged.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * APP用户粉丝信息表
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Data
@TableName("app_user_fan")
public class AppUserFan implements Serializable {

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
     * 粉丝ID
     */
    private Integer fansId;

    /**
     * 粉丝昵称
     */
    private String fansName;

    /**
     * 粉丝忠实度   0 正常   1 潜力股   2 勇士   3 铁杆   4 老铁
     */
    private Integer level;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 是否可见我动态
     */
    private Integer isDisplay;

    /**
     * 是否屏蔽私信
     */
    private Integer isShieldLetter;

    /**
     * 是否屏蔽评论
     */
    private Integer isShieldComment;


}
