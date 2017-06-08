package com.gome.o2m.swagger.service;

import com.github.pagehelper.PageInfo;
import com.gome.o2m.swagger.model.City;

import java.util.List;

/**
 * @author wangpeng24
 * @date 2017/6/6 17:40
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface CityReadService {

    List<City> list();

    PageInfo<City> pageList();
}
