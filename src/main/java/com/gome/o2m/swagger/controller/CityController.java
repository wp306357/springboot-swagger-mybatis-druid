package com.gome.o2m.swagger.controller;

import com.github.pagehelper.PageInfo;
import com.gome.o2m.swagger.model.City;
import com.gome.o2m.swagger.service.CityReadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpeng24
 * @date 2017/6/6 17:38
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Api(value = "city", description="城市相关")
@RestController
@RequestMapping("/city")
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityReadService cityReadService;

    @ApiOperation(notes = "城市列表", value = "城市列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<City> list(@RequestBody City city){
        logger.info("city.list()");
        return cityReadService.list();
    }

    @ApiOperation(notes = "城市分页列表", value = "城市分页列表")
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public PageInfo<City> pageList(){
        logger.info("city.pageList()");
        return cityReadService.pageList();
    }
}
