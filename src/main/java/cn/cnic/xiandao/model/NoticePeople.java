package cn.cnic.xiandao.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;


@TableName("notice_people")
public class NoticePeople {

    @TableId(value = "nid")
    private int nid;

    private int eid;
    private Date noticetime;
    private String noticeunit;
    private String noticemethod;
    private String describeevent;


    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNoticeunit() {
        return noticeunit;
    }

    public void setNoticeunit(String noticeunit) {
        this.noticeunit = noticeunit;
    }

    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticemethod() {
        return noticemethod;
    }

    public void setNoticemethod(String noticemethod) {
        this.noticemethod = noticemethod;
    }

    public String getDescribeevent() {
        return describeevent;
    }

    public void setDescribeevent(String describeevent) {
        this.describeevent = describeevent;
    }

    @Override
    public String toString() {
        return "NoticePeople{" +
                "nid=" + nid +
                ", eid=" + eid +
                ", noticetime=" + noticetime +
                ", noticeunit='" + noticeunit + '\'' +
                ", noticemethod='" + noticemethod + '\'' +
                ", describeevent='" + describeevent + '\'' +
                '}';
    }
}
