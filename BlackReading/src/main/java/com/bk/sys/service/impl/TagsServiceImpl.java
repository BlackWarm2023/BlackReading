package com.bk.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bk.sys.entity.Tags;
import com.bk.sys.mapper.TagsMapper;
import com.bk.sys.service.ITagsService;
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
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

}
