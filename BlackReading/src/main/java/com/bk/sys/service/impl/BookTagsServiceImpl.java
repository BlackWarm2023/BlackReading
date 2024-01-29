package com.bk.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bk.sys.entity.BookTags;
import com.bk.sys.mapper.BookTagsMapper;
import com.bk.sys.service.IBookTagsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BlackWarm
 * @since 2023-12-25
 */
@Service
public class BookTagsServiceImpl extends ServiceImpl<BookTagsMapper, BookTags> implements IBookTagsService {

}
