package com.lzz.climate.controller;

import com.lzz.climate.entity.UserInfoEntity;
import com.lzz.climate.service.UserInfoService;
import com.lzz.climate.utils.PageUtils;
import com.lzz.climate.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 13:04:37
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String account;
    /**
     * 列表
     */
    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' )")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{userid}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' , 'ROLE_USER')")
    public R info(@PathVariable("userid") String userid){
		UserInfoEntity userInfo = userInfoService.getById(userid);

        return R.ok().put("userInfo", userInfo);
    }


    /**
     * 修改
     */
    @PostMapping("/update")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' )")
    public R update(@RequestBody UserInfoEntity userInfo){
		userInfoService.updateById(userInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' )")
    public R delete(@RequestBody String[] userids){
		userInfoService.removeByIds(Arrays.asList(userids));

        return R.ok();
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public R login(@RequestBody UserInfoEntity userInfoEntity){
        if (userInfoService.login(userInfoEntity)){
            return R.ok("登录成功");
        }

        return R.error("登录失败");
    }

    @PostMapping("/toregister")
    @ApiOperation("注册发送邮件")
    public R registerMail(@ApiParam("发送人") @RequestParam("address") String address ,
                          @ApiParam("标题") @RequestParam("subject") String subject ,
                          @ApiParam("正文") @RequestParam("body") String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(address);
        message.setTo(account);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        return R.ok("邮件发送成功，等待后台审核");
    }

    @PostMapping("/register")
    @ApiOperation("后台进行注册")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' )")
    public R register(@RequestBody UserInfoEntity userEntity){
        if (userInfoService.register(userEntity)){
            return R.ok();
        }
        return R.error("注册失败");
    }

    @PostMapping("/regsuccess")
    @ApiOperation("注册成功向用户发送邮件")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_SUPERADMIN' )")
    public R regSuccessMail(@ApiParam("发送人") @RequestParam("address") String address ,
                            @ApiParam("标题") @RequestParam("subject") String subject ,
                            @ApiParam("正文") @RequestParam("body") String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(account);
        message.setTo(address);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        return R.ok("注册成功邮件已发送");
    }


}
