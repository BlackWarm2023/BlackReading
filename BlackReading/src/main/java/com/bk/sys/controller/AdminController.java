package com.bk.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bk.commen.vo.CodeNum;
import com.bk.commen.vo.Result;
import com.bk.sys.entity.Admin;
import com.bk.sys.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@RestController
@Slf4j
@RequestMapping("/sys/admin")
// @CrossOrigin 跨域处理,但每个都要加,比较麻烦,还是使用配置类比较方便
public class AdminController {

    @Autowired
    public IAdminService adminService;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @ApiOperation("获取所有管理员")
    @GetMapping("/all")
    public Result<List<Admin>> getAllAdmin(){
        List<Admin> list = adminService.list();
        return Result.success(list,"查询成功");
    }

    @ApiOperation("用户 token 验证")
    @GetMapping("/info")
    public Result<Map<String,Object>> info(@RequestParam("token") String token){

        // 根据 token 获取用户信息, redis
        Map<String,Object> data = adminService.getAdminInfo(token);

        if (data != null){
            return Result.success(data, "success");
        }

        return Result.fail(CodeNum.ERROR.getNum(),"登录信息无效,请重新登录");
    }


    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Admin admin){

        log.info("admin::" + admin);
        Map<String, Object> data =  adminService.login(admin);


        if (data != null){
            return Result.success(data, "success");
        }
        return Result.fail(CodeNum.ERROR.getNum(),"用户名或密码错误");
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        adminService.logout(token);
        return Result.success();
    }

    @ApiOperation("分页查询")
    @GetMapping("/getList")
    public Result<Map<String, Object>> getUserList(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "byname", required = false) String byname,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam("pageNo") Long pageNo,
            @RequestParam("pageSize") Long pageSize
    ){

        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(name),Admin::getName, name);
        wrapper.like(StringUtils.hasLength(phone),Admin::getPhone, phone);
        wrapper.like(StringUtils.hasLength(byname),Admin::getByname, byname);
        wrapper.like(StringUtils.hasLength(email),Admin::getEmail, email);


        Page<Admin> page = new Page<>(pageNo,pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());

        return Result.success(data);
    }

    @ApiOperation("新增管理员")
    @PostMapping("/addAdmin")
    public Result<?> addUser(@RequestBody Admin admin,@RequestParam(value = "id",defaultValue = "1") String id){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        userService.save(user);
        adminService.addAdmin(admin,id);
        return Result.success("新增用户成功");
    }

    @ApiOperation("修改管理员")
    @PutMapping("/updateAdmin")
    public Result<?> updateUser(@RequestBody Admin admin,@RequestParam(value = "id",defaultValue = "1") String id){
        admin.setPassword(null);
        adminService.updateAdmin(admin,id);
        return Result.success("修改用户成功");
    }

}
