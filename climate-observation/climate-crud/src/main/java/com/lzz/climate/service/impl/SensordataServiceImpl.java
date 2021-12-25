package com.lzz.climate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.climate.dao.SensordataDao;
import com.lzz.climate.entity.SensordataEntity;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.service.SensordataService;
import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sensordataService")
public class SensordataServiceImpl extends ServiceImpl<SensordataDao, SensordataEntity> implements SensordataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SensordataEntity> page = this.page(
                new Query<SensordataEntity>().getPage(params),
                new QueryWrapper<SensordataEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<SensordataEntity> testInfo(Integer page) {

        return this.page(new Page<>(page , 7));
    }
}