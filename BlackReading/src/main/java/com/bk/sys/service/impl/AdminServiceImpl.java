package com.bk.sys.service.impl;

import com.bk.sys.entity.Admin;
import com.bk.sys.mapper.AdminMapper;
import com.bk.sys.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
