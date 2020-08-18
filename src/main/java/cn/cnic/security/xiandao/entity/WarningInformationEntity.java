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
@TableName("warning_information")
public class WarningInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer wId;
	/**
	 * 
	 */
	private String warnType;
	/**
	 * 
	 */
	private String warnDetails;

	private Integer total;

}
