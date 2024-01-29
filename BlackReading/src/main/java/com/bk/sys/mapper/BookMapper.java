package com.bk.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.sys.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
