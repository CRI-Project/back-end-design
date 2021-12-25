package com.lzz.climate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.climate.dao.SensordatatestDao;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.service.SensordatatestService;
import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sensordatatestService")
public class SensordatatestServiceImpl extends ServiceImpl<SensordatatestDao, SensordatatestEntity> implements SensordatatestService {

    @Autowired
    private SensordatatestService sensordatatestService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SensordatatestEntity> page = this.page(
                new Query<SensordatatestEntity>().getPage(params),
                new QueryWrapper<SensordatatestEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public IPage<SensordatatestEntity> testInfo(Integer page) {

        return this.page(new Page<>(page , 7));
    }

}