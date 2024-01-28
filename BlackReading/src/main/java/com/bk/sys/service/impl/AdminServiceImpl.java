package com.bk.sys.service.impl;

import com.bk.commen.utils.JwtUtils;
import com.bk.sys.entity.Admin;
import com.bk.sys.mapper.AdminMapper;
import com.bk.sys.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
//
    @Autowired
    private AdminMapper adminMapper;

    //加密密码解密需要
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(Admin admin) {

        // 根据用户名或账号和密码查询
        Admin loginAdmin = adminMapper.getAdminByNameAndPassword(admin.getName(),admin.getPassword());
        if (loginAdmin == null){
            loginAdmin = adminMapper.getAdminByByNameAndPassword(admin.getName(),admin.getPassword());
        }

        //结果不为空,则生成token,并将用户信息存入 redis
        if (loginAdmin != null ){
//            log.info("logAdmin:: " + loginAdmin);

            // 暂时用 UUID,最终方案是 jwt
//            String key = "user::" + UUID.randomUUID();
//            log.info("key::" + key);

            // 存入 redis,  密码没必要返回与存入 redis
            loginAdmin.setPassword(null);
            // 10, TimeUnit.MINUTES 这一串是声明数据存入 redis 的有效期为 10 分钟
//            redisTemplate.opsForValue().set(key,loginAdmin,30, TimeUnit.MINUTES);

            //创建 jwt
            System.out.println("loginUser: " + loginAdmin);
            String token = jwtUtils.creatToken(loginAdmin);
            System.out.println("token: " + token);

            // 返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",token);

            return data;
        }

        return null;
    }

    @Override
    public Map<String, Object> getAdminInfo(String token) {

        Admin loginAdmin = null;
        /**
         *  jwtUtils  解析 JWT 令牌，
         *  并尝试将其解析为  Admin  类。
         *  如果解析成功，则将解析后的用户对象存储在
         *   loginAdmin  变量中。
         *   如果解析失败，则会打印异常堆栈信息。
         */
        try {
            loginAdmin = jwtUtils.parseToken(token, Admin.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (loginAdmin != null){
            Map<String,Object> data = new HashMap<>();
            data.put("name",loginAdmin.getName());
            data.put("byname",loginAdmin.getByname());
            data.put("id",loginAdmin.getId());

            return data;
        }

        return null;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    @Transactional
    // @Transactional 事务的注解
    public void addAdmin(Admin admin, String id) {

        // 写入管理员表,
        Admin newAdmin = new Admin();
        newAdmin = admin;
        newAdmin.setCreateId(id);
        adminMapper.insert(newAdmin);
    }

    @Override
    public void updateAdmin(Admin admin, String id) {

        // 获取当前时间
        Date date = new Date();
        // 将当前的时间格式转化为 MySQL 的 datetime 格式
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        // 更新管理员表
        Admin oldAdmin = adminMapper.getAdminById(admin.getId());
        admin.setCreateId(oldAdmin.getCreateId());
        admin.setCreateTime(oldAdmin.getCreateTime());
        admin.setUpdateId(id);
        admin.setUpdateTime(LocalDateTime.parse(dateStr));
        adminMapper.updateById(admin);
    }
}
