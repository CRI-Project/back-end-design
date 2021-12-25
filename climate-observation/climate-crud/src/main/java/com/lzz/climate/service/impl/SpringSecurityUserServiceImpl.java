package com.lzz.climate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lzz.climate.entity.SecurityEntity;
import com.lzz.climate.entity.UserInfoEntity;
import com.lzz.climate.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringSecurityUserServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;


    @Override
    public SecurityEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfoEntity::getUsername , username);
        UserInfoEntity user=userInfoService.getOne(wrapper);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid account and password");
        }

       return new SecurityEntity(user , getGrantedAuthority(user));
    }

    public List<GrantedAuthority> getGrantedAuthority(UserInfoEntity user) {
        List<GrantedAuthority> auth=new ArrayList<>();
        LambdaQueryWrapper<UserInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfoEntity::getUsername , user.getUsername());
        UserInfoEntity userEntity = userInfoService.getOne(wrapper);
        if (userEntity != null){
            if (userEntity.getLevel() == 0){
                auth.add(new SimpleGrantedAuthority("ROLE_VISITOR"));
            }else if (userEntity.getLevel() == 1){
                auth.add(new SimpleGrantedAuthority("ROLE_USER"));
            }else if (userEntity.getLevel()==2){
                auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }else if (userEntity.getLevel()==3){
                auth.add(new SimpleGrantedAuthority("ROLE_SUPERADMIN"));
            }
            return auth;
        }
        return auth;
    }


}
