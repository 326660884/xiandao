package cn.cnic.xiandao.model;

import java.util.Date;

public class ExhibiSinoEventWithNoticePeople extends ExhibitSinoEvent {
    private Integer nid;
    private String noticeunit;
    private String noticemethod;
    private String describeevent;
    private Integer eid;
    private Date noticetime;
    private Date resolvetime;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNoticeunit() {
        return noticeunit;
    }

    public void setNoticeunit(String noticeunit) {
        this.noticeunit = noticeunit;
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

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public Date getResolvetime() {
        return resolvetime;
    }

    public void setResolvetime(Date resolvetime) {
        this.resolvetime = resolvetime;
    }

    @Override
    public String toString() {
        return "ExhibiSinoEventWithNoticePeople{" +
                "nid=" + nid +
                ", noticeunit='" + noticeunit + '\'' +
                ", noticemethod='" + noticemethod + '\'' +
                ", describeevent='" + describeevent + '\'' +
                ", eid=" + eid +
                ", noticetime=" + noticetime +
                ", resolvetime=" + resolvetime +
                '}';
    }
}
