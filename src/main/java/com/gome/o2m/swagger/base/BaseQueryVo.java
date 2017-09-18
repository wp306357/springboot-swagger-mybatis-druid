package com.gome.o2m.swagger.base;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/15.
 */
@Data
public class BaseQueryVo extends BaseVo{
    private Integer pageSize = 10;
    private Integer currentPage = 1;
}
