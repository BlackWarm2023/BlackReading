package com.bk.sys.mapper;

import com.bk.sys.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    Admin getAdminByNameAndPassword(@Param("name") String name, @Param("password") String password);

    Admin getAdminByByNameAndPassword(@Param("byname") String byname, @Param("password") String password);

    Admin getAdminById(@Param("id") String id);
}
