package com.lzz.climate.controller;

import java.util.Arrays;
import java.util.Map;

import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.lzz.climate.entity.SensorEntity;
import com.lzz.climate.service.SensorService;




/**
 * 
 *
 * @author lzz
 * @email 1399508400@qq.com
 * @date 2021-12-13 17:55:48
 */
@RestController
@RequestMapping("climate/sensor")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' , 'ROLE_USER')")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sensorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SensorEntity sensor = sensorService.getById(id);

        return R.ok().put("sensor", sensor);
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SensorEntity sensor){
		sensorService.save(sensor);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody SensorEntity sensor){
		sensorService.updateById(sensor);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		sensorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
