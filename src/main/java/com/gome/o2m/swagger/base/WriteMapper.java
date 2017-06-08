package com.gome.o2m.swagger.base;

import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * 写操作的Mapper接口集合，所有写操作的Dao继承WriteMapper来
 * 实现基本的单表读操作
 * @author wangpeng24
 * @date 2017/6/6 17:36
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface WriteMapper<T> extends BaseUpdateMapper<T>, BaseDeleteMapper<T>, BaseInsertMapper<T>, UpdateByExampleSelectiveMapper<T> {
}
