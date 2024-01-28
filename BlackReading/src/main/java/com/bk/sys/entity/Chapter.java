package com.bk.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-12-25
 */
@TableName("b_chapter")
@ApiModel(value = "Chapter对象", description = "")
public class Chapter implements Serializable {

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

    @ApiModelProperty("章节数")
    private Integer no;

    @ApiModelProperty("章节名")
    private String name;

    @ApiModelProperty("章节内容")
    private String text;

    @ApiModelProperty("会员")
    private Integer vip;

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

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Chapter{" +
            "id = " + id +
            ", createTime = " + createTime +
            ", createId = " + createId +
            ", updateTime = " + updateTime +
            ", updateId = " + updateId +
            ", delFlag = " + delFlag +
            ", no = " + no +
            ", name = " + name +
            ", text = " + text +
            ", vip = " + vip +
        "}";
    }
}
