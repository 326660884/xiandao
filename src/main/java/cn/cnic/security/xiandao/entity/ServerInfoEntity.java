package cn.cnic.security.xiandao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物理服务器信息
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
@Data
@TableName("server_info")
public class ServerInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer sid;
	/**
	 * 
	 */
	private String serverIp;
	/**
	 * 
	 */
	private String serverName;
	/**
	 * 
	 */
	private String memoryTotal;
	/**
	 * 
	 */
	private String disks;
	/**
	 * 网卡
	 */
	private String networkCard;
	/**
	 * 
	 */
	private String topic;

}
