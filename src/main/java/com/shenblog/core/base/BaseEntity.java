package com.shenblog.core.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ShenChuanBiao
 * @title: BaseEntity
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 17:21
 */
@Data
public class BaseEntity {
    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updater;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 删除状态
     */
    @ApiModelProperty(value = "删除状态")
    private Integer deleted;
}
