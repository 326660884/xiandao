package cn.cnic.xiandao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.ToString;

import java.util.Date;

@ToString
@TableName("computer_property")
public class ComputerProperty {

    @TableId(type=IdType.AUTO)
    private Integer id;

    private String ip;

    private String mac;

    private Integer role;

    private String roleName;

    private String phone;

    private Date createTime;

    private Integer status;

    private Integer safetyDataCount;

    private Integer loopholeDataCount;

    private String assetType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSafetyDataCount() {
        return safetyDataCount;
    }

    public void setSafetyDataCount(Integer safetyDataCount) {
        this.safetyDataCount = safetyDataCount;
    }

    public Integer getLoopholeDataCount() {
        return loopholeDataCount;
    }

    public void setLoopholeDataCount(Integer loopholeDataCount) {
        this.loopholeDataCount = loopholeDataCount;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }
}