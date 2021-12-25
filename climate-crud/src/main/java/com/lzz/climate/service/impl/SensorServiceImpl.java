package com.lzz.climate.service.impl;

import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.lzz.climate.dao.SensorDao;
import com.lzz.climate.entity.SensorEntity;
import com.lzz.climate.service.SensorService;


@Service("sensorService")
public class SensorServiceImpl extends ServiceImpl<SensorDao, SensorEntity> implements SensorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SensorEntity> page = this.page(
                new Query<SensorEntity>().getPage(params),
                new QueryWrapper<SensorEntity>()
        );

        return new PageUtils(page);
    }

}