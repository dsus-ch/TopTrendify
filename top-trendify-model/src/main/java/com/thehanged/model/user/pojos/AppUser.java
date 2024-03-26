package com.thehanged.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * APP用户信息表
 * </p>
 *
 * @author thehanged
 * @since 2024-03-25
 */
@Data
@TableName("app_user")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 密码、通信等加密盐
     */
    private String salt;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码,md5加密
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String image;

    /**
     * 0 男   1 女   2 未知
     */
    private Integer gender;

    /**
     * 0 未   1 是
     */
    private Integer isCertification;

    /**
     * 是否身份认证
     */
    private Boolean isIdentityAuthentication;

    /**
     * 0正常   1锁定
     */
    private Integer status;

    /**
     * 0 普通用户   1 自媒体人   2 大V
     */
    private Integer flag;

    /**
     * 注册时间
     */
    private LocalDateTime createdTime;


}
