package com.lzz.climate.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.service.SensordatatestService;
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
@RequestMapping("/sensordatatest")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' , 'ROLE_USER')")
public class SensordatatestController {
    @Autowired
    private SensordatatestService sensordatatestService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("查")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sensordatatestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{processorCode}")
    @ApiOperation("按id查")
    public R info(@PathVariable("processorCode") String processorCode){
		SensordatatestEntity sensordatatest = sensordatatestService.getById(processorCode);

        return R.ok().put("sensordatatest", sensordatatest);
    }


    @GetMapping("testInfo/{page}")
    @ApiOperation("分页获取sensor数据")
    public IPage<SensordatatestEntity> testInfo(@PathVariable Integer page){
        return sensordatatestService.testInfo(page);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("增")
    public R save(@RequestBody SensordatatestEntity sensordatatest){
		sensordatatestService.save(sensordatatest);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("改")
    public R update(@RequestBody SensordatatestEntity sensordatatest){
		sensordatatestService.updateById(sensordatatest);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删")
    public R delete(@RequestBody String[] processorCodes){
		sensordatatestService.removeByIds(Arrays.asList(processorCodes));

        return R.ok();
    }

}
