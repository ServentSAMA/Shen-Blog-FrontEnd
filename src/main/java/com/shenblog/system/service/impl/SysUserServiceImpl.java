package com.shenblog.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenblog.system.entity.SysUser;
import com.shenblog.system.mapper.SysUserMapper;
import com.shenblog.system.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @author ShenChuanBiao
 * @title: SysUserServiceImpl
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 17:38
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService {
}
