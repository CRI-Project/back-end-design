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
@TableName("sensordata")
public class SensordataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "SensordataEntity{" +
				"id=" + id +
				", jsonMessageId='" + jsonMessageId + '\'' +
				", processorCode='" + processorCode + '\'' +
				", processorShortname='" + processorShortname + '\'' +
				", processorModel='" + processorModel + '\'' +
				", sensorName='" + sensorName + '\'' +
				", captureType='" + captureType + '\'' +
				", dataCaptureEvent='" + dataCaptureEvent + '\'' +
				", captureDataTime=" + captureDataTime +
				", eventIndex=" + eventIndex +
				", sensateName='" + sensateName + '\'' +
				", ppm=" + ppm +
				", celcius=" + celcius +
				", temperature=" + temperature +
				", huminity=" + huminity +
				", filtername='" + filtername + '\'' +
				", longitude=" + longitude +
				", latitude=" + latitude +
				", hsModel='" + hsModel + '\'' +
				", hsManufacturer='" + hsManufacturer + '\'' +
				", fuelName='" + fuelName + '\'' +
				", hstDescription='" + hstDescription + '\'' +
				", fuFilterName='" + fuFilterName + '\'' +
				", fuFilterModel='" + fuFilterModel + '\'' +
				", cRfid='" + cRfid + '\'' +
				", cInstalled=" + cInstalled +
				", ctDescription='" + ctDescription + '\'' +
				", status='" + status + '\'' +
				", ssmaTimestamp=" + ssmaTimestamp +
				'}';
	}

	/**
	 * 
	 */
	@TableId
	private Integer id;
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
	private Double huminity;
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
