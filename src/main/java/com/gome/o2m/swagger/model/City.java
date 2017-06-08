package com.gome.o2m.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author wangpeng24
 * @date 2017/6/6 16:00
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
@ToString
@ApiModel(value = "City", description = "城市")
public class City {
    /**
     * id
     */
    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * state
     */
    @ApiModelProperty(value = "state")
    private String state;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;
}
