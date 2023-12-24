package com.bk.sys.mapper;

import com.bk.sys.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-23
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
