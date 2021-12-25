package com.lzz.climate.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzz.climate.entity.SensordataEntity;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.service.SensordataService;
import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-01 12:00:44
 */
@RestController
@RequestMapping("/sensordata")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' , 'ROLE_USER')")
public class SensordataController {
    @Autowired
    private SensordataService sensordataService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("查")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sensordataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("按id查")
    public R info(@PathVariable("id") Integer id){
		SensordataEntity sensordata = sensordataService.getById(id);

        return R.ok().put("sensordata", sensordata);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("增")
    public R save(@RequestBody SensordataEntity sensordata){
		sensordataService.save(sensordata);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("改")
    public R update(@RequestBody SensordataEntity sensordata){
		sensordataService.updateById(sensordata);

        return R.ok();
    }

    @GetMapping("testInfo/{page}")
    @ApiOperation("分页获取sensor数据")
    public IPage<SensordataEntity> testInfo(@PathVariable Integer page){
        return sensordataService.testInfo(page);
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删")
    public R delete(@RequestBody Integer[] ids){
		sensordataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
