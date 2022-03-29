package com.shenblog.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shenblog.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ShenChuanBiao
 * @title: SysRole
 * @projectName system
 * @description: TODO
 * @date 2022/3/28 11:09
 */
@Data
@ApiModel("后台角色实体")
@TableName("blog_sys_roles")
public class SysRole extends BaseEntity {

    private String roleName;

    private String resource;

    private String userId;

}
