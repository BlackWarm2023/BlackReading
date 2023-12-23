package com.bk.sys.service.impl;

import com.bk.sys.entity.User;
import com.bk.sys.mapper.UserMapper;
import com.bk.sys.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
