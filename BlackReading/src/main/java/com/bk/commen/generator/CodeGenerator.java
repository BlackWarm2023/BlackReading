package com.bk.commen.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Description: MP 代码生成器
 * @author: BlackWarm
 * @date: 2023年 12月 23日  19:23
 */
public class CodeGenerator {
    public static void main(String[] args) {

        // 数据库连接
        String url = "jdbc:mysql://localhost:3306/blackreading?useUnicode=true&charcterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        // 设置模块名字
        String moduleName = "sys";
        // 设置自动生成的 mapper.xml 生成路径
        String mapperLocation = "D:\\IDEA\\IDEA_WORK_SPACE\\BlackReading\\src\\main\\resources\\mapper\\" + moduleName;

        // 需要自动生成对应 java 文件的表
        String tables = "b_admin,b_book,b_book_chapter,b_book_tags,b_chapter," +
                "b_menu,b_role,b_role_menu,b_tags,b_user,b_user_book," +
                "b_user_chapter,b_user_role";
        // 指定代码生成路径
        String outCodeLocation = "D:\\IDEA\\IDEA_WORK_SPACE\\BlackReading\\src\\main\\java";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("BlackWarm") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outCodeLocation); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.bk") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("b_");// 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
