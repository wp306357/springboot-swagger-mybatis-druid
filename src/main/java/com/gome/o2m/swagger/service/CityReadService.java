package com.gome.o2m.swagger.service;

import com.gome.o2m.swagger.model.City;
import com.gome.o2m.swagger.vo.PageInfoVo;

import java.util.List;

/**
 * @author wangpeng24
 * @date 2017/6/6 17:40
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface CityReadService {

    List<City> list();

    PageInfoVo<City> pageList();

    City getById(Long id);
}
