package com.lzz.climate.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzz.climate.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 13:04:37
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
	
}
