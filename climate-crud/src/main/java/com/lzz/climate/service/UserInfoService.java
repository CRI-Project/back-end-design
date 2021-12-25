package com.lzz.climate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.climate.entity.UserInfoEntity;
import com.lzz.climate.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 13:04:37
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    boolean login(UserInfoEntity userInfoEntity);

    boolean register(UserInfoEntity userInfoEntity);
}

