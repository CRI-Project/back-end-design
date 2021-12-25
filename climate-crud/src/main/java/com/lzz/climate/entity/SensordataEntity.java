package com.lzz.climate.entity;

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
@TableName("sensordata")
public class SensordataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String jsonMessageId;
	/**
	 * 
	 */
	private String processorCode;
	/**
	 * 
	 */
	private String processorShortname;
	/**
	 * 
	 */
	private String processorModel;
	/**
	 * 
	 */
	private String sensorName;
	/**
	 * 
	 */
	private String captureType;
	/**
	 * 
	 */
	private String dataCaptureEvent;
	/**
	 * 
	 */
	private Date captureDataTime;
	/**
	 * 
	 */
	private Integer eventIndex;
	/**
	 * 
	 */
	private String sensateName;
	/**
	 * 
	 */
	private Double ppm;
	/**
	 * 
	 */
	private Boolean celcius;
	/**
	 * 
	 */
	private Double temperature;
	/**
	 * 
	 */
	private Double humidity;
	/**
	 * 
	 */
	private String filtername;
	/**
	 * 
	 */
	private Double longitude;
	/**
	 * 
	 */
	private Double latitude;
	/**
	 * 
	 */
	private String hsModel;
	/**
	 * 
	 */
	private String hsManufacturer;
	/**
	 * 
	 */
	private String fuelName;
	/**
	 * 
	 */
	private String hstDescription;
	/**
	 * 
	 */
	private String fuFilterName;
	/**
	 * 
	 */
	private String fuFilterModel;
	/**
	 * 
	 */
	private String cRfid;
	/**
	 * 
	 */
	private Date cInstalled;
	/**
	 * 
	 */
	private String ctDescription;
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private Date ssmaTimestamp;

}
