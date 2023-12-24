package com.bk.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("b_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
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

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("会员等级")
    private Integer vip;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("用户余额")
    private Double balance;

    @ApiModelProperty("用户充值总数")
    private Double expended;

    @ApiModelProperty("用户手机号")
    private Integer phone;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("用户生日")
    private LocalDate birth;

    @ApiModelProperty("免费货币")
    private Double free;

    @ApiModelProperty("等级")
    private Integer level;

    @ApiModelProperty("地址")
    private String adress;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getExpended() {
        return expended;
    }

    public void setExpended(Double expended) {
        this.expended = expended;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Double getFree() {
        return free;
    }

    public void setFree(Double free) {
        this.free = free;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
            "id = " + id +
            ", createTime = " + createTime +
            ", createId = " + createId +
            ", updateTime = " + updateTime +
            ", updateId = " + updateId +
            ", delFlag = " + delFlag +
            ", name = " + name +
            ", byname = " + byname +
            ", password = " + password +
            ", sex = " + sex +
            ", vip = " + vip +
            ", avatar = " + avatar +
            ", balance = " + balance +
            ", expended = " + expended +
            ", phone = " + phone +
            ", email = " + email +
            ", age = " + age +
            ", birth = " + birth +
            ", free = " + free +
            ", level = " + level +
            ", adress = " + adress +
        "}";
    }
}
