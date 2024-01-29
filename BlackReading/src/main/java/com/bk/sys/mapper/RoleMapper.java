package com.bk.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getAll();

}
