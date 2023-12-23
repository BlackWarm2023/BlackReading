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
@TableName("b_book_chapter")
@ApiModel(value = "BookChapter对象", description = "")
public class BookChapter implements Serializable {

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

    @ApiModelProperty("书籍id")
    private String bookId;

    @ApiModelProperty("章节id")
    private String chapterId;

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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toString() {
        return "BookChapter{" +
            "id = " + id +
            ", createTime = " + createTime +
            ", createId = " + createId +
            ", updateTime = " + updateTime +
            ", updateId = " + updateId +
            ", delFlag = " + delFlag +
            ", bookId = " + bookId +
            ", chapterId = " + chapterId +
        "}";
    }
}
