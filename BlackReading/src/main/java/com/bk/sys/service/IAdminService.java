package com.bk.sys.service;

import com.bk.sys.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
public interface IAdminService extends IService<Admin> {
//
    Map<String, Object> login(Admin admin);

    Map<String, Object> getAdminInfo(String token);

    void logout(String token);

    void addAdmin(Admin admin, String id);

    void updateAdmin(Admin admin, String id);
}
