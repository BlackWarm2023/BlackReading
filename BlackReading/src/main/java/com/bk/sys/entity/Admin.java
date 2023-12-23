package com.bk.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-23
 */
@TableName("b_admin")
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getByname() {
        return byname;
    }

    public void setByname(String byname) {
        this.byname = byname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id = " + id +
            ", createTime = " + createTime +
            ", createId = " + createId +
            ", updateTime = " + updateTime +
            ", updateId = " + updateId +
            ", delFlag = " + delFlag +
            ", name = " + name +
            ", byname = " + byname +
            ", password = " + password +
            ", phone = " + phone +
            ", email = " + email +
            ", level = " + level +
        "}";
    }
}
