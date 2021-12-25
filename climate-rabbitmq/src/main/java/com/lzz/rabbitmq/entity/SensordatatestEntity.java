package com.lzz.rabbitmq.entity;

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
 * @date 2021-11-01 12:00:44
 */
@Data
@TableName("sensordatatest")
public class SensordatatestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String processorCode;
	/**
	 * 
	 */
	private Date captureDataTime;
	/**
	 * 
	 */
	private Double ppm;
	/**
	 * 
	 */
	private Double temperature;
	/**
	 * 
	 */
	private Double humidity;

	@Override
	public String toString() {
		return "SensordatatestEntity{" +
				"processorCode='" + processorCode + '\'' +
				", captureDataTime=" + captureDataTime +
				", ppm=" + ppm +
				", temperature=" + temperature +
				", humidity=" + humidity +
				'}';
	}
}
