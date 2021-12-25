package com.lzz.climate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.climate.dao.UserInfoDao;
import com.lzz.climate.entity.UserInfoEntity;
import com.lzz.climate.service.UserInfoService;
import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserInfoEntity> page = this.page(
                new Query<UserInfoEntity>().getPage(params),
                new QueryWrapper<UserInfoEntity>()
        );

        return new PageUtils(page);
    }



    @Override
    public boolean login(UserInfoEntity userInfoEntity) {

        QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username" , userInfoEntity.getUsername());
        UserInfoEntity userInfoEntity1 = this.getOne(wrapper);
        if (userInfoEntity1 != null){
            return bCryptPasswordEncoder.matches(userInfoEntity.getPassword() , userInfoEntity1.getPassword());
        }
        return false;
    }


    @Override
    public boolean register(UserInfoEntity userEntity) {

        if (userEntity.getPassword() == null && userEntity.getUsername() == null){
            return false;
        }
        QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username" , userEntity.getUsername());
        UserInfoEntity userInfoEntity = this.getOne(wrapper);
        if (userInfoEntity != null){
            return false;
        }
        String pwd = userEntity.getPassword();
        pwd = bCryptPasswordEncoder.encode(pwd);
        userEntity.setPassword(pwd);
        userEntity.setLevel(1);


        return this.save(userEntity);
    }
}