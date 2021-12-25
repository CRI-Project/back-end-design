package com.lzz.climate.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.lzz.climate.entity.SensorEntity;
import com.lzz.climate.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author lzz
 * @email 1399508400@qq.com
 * @date 2021-12-13 17:55:48
 */
public interface SensorService extends IService<SensorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

