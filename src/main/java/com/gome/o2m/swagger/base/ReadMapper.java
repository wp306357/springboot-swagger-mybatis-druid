package com.gome.o2m.swagger.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;

/**
 * 读操作的Mapper接口集合，所有读操作的Dao继承ReadMapper来
 * 实现基本的单表读操作
 * @author wangpeng24
 * @date 2017/6/6 17:34
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface ReadMapper<T> extends BaseMapper<T>, BaseSelectMapper<T>, SelectByExampleMapper<T>, SelectCountMapper<T>, SelectCountByExampleMapper<T> {
}
