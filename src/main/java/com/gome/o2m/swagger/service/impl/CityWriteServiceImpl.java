package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.CityWriteMapper;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.City;
import com.gome.o2m.swagger.service.CityWriteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangpeng24
 * @date 2017/7/17 15:24
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Service
public class CityWriteServiceImpl implements CityWriteService {

    @Autowired
    private CityWriteMapper cityWriteMapper;

    @Override
    public Boolean insert(City city) throws CommonException {
        if(null == city || StringUtils.isBlank(city.getName().trim())){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        return cityWriteMapper.insert(city) > 0;
    }
}
