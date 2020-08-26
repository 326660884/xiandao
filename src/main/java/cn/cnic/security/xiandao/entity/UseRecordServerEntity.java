package cn.cnic.security.xiandao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
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
    private Double memory = 0d;
    /**
     *
     */
    private Double cpuUse = 0d;
    /**
     *
     */
    private Integer responseTime = 0;
    /**
     * 吞吐量
     */
    private Integer throughput = 0;
    /**
     * 查询率
     */
    private Double queryRate = 0d;
    /**
     * 硬盘使用率
     */
    private Double diskUse = 0d;
    /**
     * 硬盘io
     */
    private Double diskSpeed = 0d;
    /**
     * 带宽
     */
    private Double bandwidth = 0d;
    /**
     * 下行流量
     */
    private Double bandwinthDown = 0d;
    /**
     * 进程数量
     */
    private Integer processesNumber = 0;
    /**
     * 预警类型
     */
    private String warnType;

    @TableField(exist = false)
    private String topic;

}
