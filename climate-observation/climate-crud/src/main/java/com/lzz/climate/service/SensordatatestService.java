package com.lzz.climate.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-01 12:00:44
 */
public interface SensordatatestService extends IService<SensordatatestEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<SensordatatestEntity> testInfo(Integer page);
}

