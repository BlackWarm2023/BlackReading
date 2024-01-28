package com.bk.sys.service.impl;

import com.bk.sys.entity.Book;
import com.bk.sys.mapper.BookMapper;
import com.bk.sys.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
