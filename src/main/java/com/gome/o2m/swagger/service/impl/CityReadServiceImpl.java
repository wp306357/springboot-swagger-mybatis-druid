package com.gome.o2m.swagger.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gome.o2m.swagger.dao.CityReadMapper;
import com.gome.o2m.swagger.model.City;
import com.gome.o2m.swagger.service.CityReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * City业务层
 * @author wangpeng24
 * @date 2017/6/6 17:44
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Service
public class CityReadServiceImpl implements CityReadService {

    @Autowired
    private CityReadMapper cityReadMapper;

    @Override
    public List<City> list() {
        return cityReadMapper.selectAll();
    }

    @Override
    public PageInfo<City> pageList() {
        PageHelper.startPage(1,1);
        List<City> cities = cityReadMapper.selectAll();
        return new PageInfo(cities);
    }
}
