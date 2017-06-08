package com.gome.o2m.swagger.vo;

import com.gome.o2m.swagger.base.BaseVo;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 分页记录返回对象
 * @author wangpeng24
 * @date 2017/6/8 11:29
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
@ToString
public class PageInfoVo<T> extends BaseVo {
    /**
     * 返回记录
     */
    private List<T> rows;
    /**
     * 记录总条数
     */
    private long total;
    /**
     * 每页条数
     */
    private int pageSize = 10;
    /**
     * 当前页
     */
    private int currentPage = 1;
}
