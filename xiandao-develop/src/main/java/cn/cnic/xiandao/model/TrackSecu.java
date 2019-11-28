package cn.cnic.xiandao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
@TableName("track_secu")
public class TrackSecu {
    @TableId(value = "secuId",type = IdType.AUTO)
    private Integer secuid;

    private String secucode;

    private String secuname;

    private Integer frequency;

    private String remark;

    private String createuser;

    private Date createtime;

    private String updateuser;

    private Date updatetime;

    public Integer getSecuid() {
        return secuid;
    }

    public void setSecuid(Integer secuid) {
        this.secuid = secuid;
    }

    public String getSecucode() {
        return secucode;
    }

    public void setSecucode(String secucode) {
        this.secucode = secucode == null ? null : secucode.trim();
    }

    public String getSecuname() {
        return secuname;
    }

    public void setSecuname(String secuname) {
        this.secuname = secuname == null ? null : secuname.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}