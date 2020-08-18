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
 * @date 2020-08-18 16:47:40
 */
@Data
@TableName("sys_login")
public class SysLoginEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String loginName;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String userName;

}
