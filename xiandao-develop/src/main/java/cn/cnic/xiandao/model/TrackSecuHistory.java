package cn.cnic.xiandao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("track_secu_history")
public class TrackSecuHistory {

    @TableId(type = IdType.AUTO)
    private Integer hid;

    private Integer sid;

    private String notifiedPerson;

    private String ways;

    private Date createdate;

    private String remarks;

    private String phone;

    private String email;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getNotifiedPerson() {
        return notifiedPerson;
    }

    public void setNotifiedPerson(String notifiedPerson) {
        this.notifiedPerson = notifiedPerson == null ? null : notifiedPerson.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWays() {
        return ways;
    }

    public void setWays(String ways) {
        this.ways = ways == null ? null : ways.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "TrackSecuHistory{" +
                "hid=" + hid +
                ", sid=" + sid +
                ", notifiedPerson='" + notifiedPerson + '\'' +
                ", ways='" + ways + '\'' +
                ", createdate=" + createdate +
                ", remarks='" + remarks + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}