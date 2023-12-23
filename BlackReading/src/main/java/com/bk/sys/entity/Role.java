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
@TableName("b_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {

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

    @Override
    public String toString() {
        return "Role{" +
            "id = " + id +
            ", createTime = " + createTime +
            ", createId = " + createId +
            ", updateTime = " + updateTime +
            ", updateId = " + updateId +
            ", delFlag = " + delFlag +
            ", name = " + name +
            ", byname = " + byname +
        "}";
    }
}
