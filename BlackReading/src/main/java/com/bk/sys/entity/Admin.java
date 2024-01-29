package com.bk.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@TableName("b_admin")
@Data
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    // 设置 id 用 uuid 策略自增,此方法是 MP 封装好的
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人id")
    private String createId;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人id")
    private String updateId;

    @ApiModelProperty("删除标记")
    private Integer delFlag;

    @ApiModelProperty("账号")
    private String name;

    @ApiModelProperty("用户名")
    private String byname;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private Integer phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("等级")
    private Integer level;



}
