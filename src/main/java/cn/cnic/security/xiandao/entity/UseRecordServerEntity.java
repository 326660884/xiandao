package cn.cnic.security.xiandao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 18:26:15
 */
@Data
@TableName("use_record_server")
public class UseRecordServerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer uId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String serverName;
	/**
	 * 
	 */
	private Double memory;
	/**
	 * 
	 */
	private Double cpuUse;
	/**
	 * 
	 */
	private Integer responseTime;
	/**
	 * 吞吐量
	 */
	private Integer throughput;
	/**
	 * 查询率
	 */
	private Double queryRate;
	/**
	 * 硬盘使用率
	 */
	private Double diskUse;
	/**
	 * 硬盘io
	 */
	private Double diskSpeed;
	/**
	 * 带宽
	 */
	private Double bandwidth;
	/**
	 * 下行流量
	 */
	private Double bandwinthDown;
	/**
	 * 进程数量
	 */
	private Integer processesNumber;
	/**
	 * 预警类型
	 */
	private String warnType;

}
