package com.shenblog.core.authentication;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.shenblog.system.entity.SysRole;
import com.shenblog.system.entity.SysUser;
import com.shenblog.system.service.ISysRoleService;
import com.shenblog.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author ShenChuanBiao
 * @title: UserDetailsServiceImpl
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 18:14
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        SysUser sysUser = sysUserService.getOne(queryWrapper);

        if (sysUser == null) {
            throw new UsernameNotFoundException("用户未找到");
        }else {
            QueryWrapper<SysRole> roleQueryWrapper = new QueryWrapper<>();
            roleQueryWrapper.eq("user_id",sysUser.getId());
            SysRole sysRole = sysRoleService.getOne(roleQueryWrapper);
            return new User(sysUser.getUsername(), sysUser.getPassword(), Lists.newArrayList(() -> sysRole.getRoleName()));

        }
    }
//    @Bean
//    public AuthenticationManager authenticationManager(){
//        return new OAuth2AuthenticationManager();
//    }

}
