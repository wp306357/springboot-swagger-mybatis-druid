package com.gome.o2m.swagger.controller;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.City;
import com.gome.o2m.swagger.service.CityReadService;
import com.gome.o2m.swagger.service.CityWriteService;
import com.gome.o2m.swagger.vo.CommonResponse;
import com.gome.o2m.swagger.vo.PageInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private CityWriteService cityWriteService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(notes = "城市列表", value = "城市列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("city:view")
    public CommonResponse<List<City>> list(@RequestBody City city){
        logger.info("city.list()");
        return CommonResponse.success(cityReadService.list());
    }

    @ApiOperation(notes = "城市分页列表", value = "城市分页列表")
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    @RequiresPermissions("city:view")
    public CommonResponse<PageInfoVo<City>> pageList(){
        logger.info("city.pageList()");
        return CommonResponse.success(cityReadService.pageList());
    }

    @ApiOperation(notes = "根据ID获取城市详情", value = "根据ID获取城市详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("city:view")
    public CommonResponse<City> getCityById(@ApiParam(value = "id", name = "城市id") @PathVariable(value = "id") Long id) throws CommonException{
        logger.info("city.getCityById()");
        return CommonResponse.success(cityReadService.getById(id));
    }

    @ApiOperation(notes = "添加城市", value = "添加城市")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("city:add")
    public CommonResponse<Boolean> add(@RequestBody City city) throws CommonException {
        logger.info("city.add()");
        Boolean flag = cityWriteService.insert(city);
        if(flag){
            return CommonResponse.success();
        }
        return CommonResponse.fail(ExceptionCodeEnum.SYSTEM_ERROR);
    }
}
