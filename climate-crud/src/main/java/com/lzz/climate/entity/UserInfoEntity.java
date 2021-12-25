package com.lzz.climate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 13:04:37
 */
@Data
@TableName("user_info")
public class UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId(type=IdType.ASSIGN_UUID)
	private String userid;
	/**
	 * 用户昵称
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 注册时间
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date updatetime;
	/**
	 *	权限等级
	 */
	private Integer level;
}
