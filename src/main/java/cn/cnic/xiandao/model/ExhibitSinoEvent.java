package cn.cnic.xiandao.model;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("exhibit_sino_event")
public class ExhibitSinoEvent  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String eventno;

    private String eventname;

    private String eventtype;

    private String eventlevel;


    private String agreement;

    private String sip;

    private String sport;

    private String sipname;

    private String sipabbr;

    private String aip;

    private String aport;

    private String aipname;

    private String aipabbr;

    private String eventfrom;

    private Integer eventfqcy;

    private String ascription;

    private Integer status;

    private String handleper;

    private String noticeemail;

    private String noticeunit;

    private String noticeper;

    private Date datetime;

    private String touser;

    private String ccuser;

    private String subject;

    private Date noticetime;

    private String noticemethod;

    private String describeevent;

    private Date resolvetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventno() {
        return eventno;
    }

    public void setEventno(String eventno) {
        this.eventno = eventno == null ? null : eventno.trim();
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype == null ? null : eventtype.trim();
    }

    public String getEventlevel() {
        return eventlevel;
    }

    public void setEventlevel(String eventlevel) {
        this.eventlevel = eventlevel == null ? null : eventlevel.trim();
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement == null ? null : agreement.trim();
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip == null ? null : sip.trim();
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport == null ? null : sport.trim();
    }

    public String getSipname() {
        return sipname;
    }

    public void setSipname(String sipname) {
        this.sipname = sipname == null ? null : sipname.trim();
    }

    public String getSipabbr() {
        return sipabbr;
    }

    public void setSipabbr(String sipabbr) {
        this.sipabbr = sipabbr == null ? null : sipabbr.trim();
    }

    public String getAip() {
        return aip;
    }

    public void setAip(String aip) {
        this.aip = aip == null ? null : aip.trim();
    }

    public String getAport() {
        return aport;
    }

    public void setAport(String aport) {
        this.aport = aport == null ? null : aport.trim();
    }

    public String getAipname() {
        return aipname;
    }

    public void setAipname(String aipname) {
        this.aipname = aipname == null ? null : aipname.trim();
    }

    public String getAipabbr() {
        return aipabbr;
    }

    public void setAipabbr(String aipabbr) {
        this.aipabbr = aipabbr == null ? null : aipabbr.trim();
    }

    public String getEventfrom() {
        return eventfrom;
    }

    public void setEventfrom(String eventfrom) {
        this.eventfrom = eventfrom == null ? null : eventfrom.trim();
    }

    public Integer getEventfqcy() {
        return eventfqcy;
    }

    public void setEventfqcy(Integer eventfqcy) {
        this.eventfqcy = eventfqcy;
    }

    public String getAscription() {
        return ascription;
    }

    public void setAscription(String ascription) {
        this.ascription = ascription == null ? null : ascription.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status == null ? null : status;
    }

    public String getHandleper() {
        return handleper;
    }

    public void setHandleper(String handleper) {
        this.handleper = handleper == null ? null : handleper.trim();
    }

    public String getNoticeemail() {
        return noticeemail;
    }

    public void setNoticeemail(String noticeemail) {
        this.noticeemail = noticeemail == null ? null : noticeemail.trim();
    }

    public String getNoticeunit() {
        return noticeunit;
    }

    public void setNoticeunit(String noticeunit) {
        this.noticeunit = noticeunit == null ? null : noticeunit.trim();
    }

    public String getNoticeper() {
        return noticeper;
    }

    public void setNoticeper(String noticeper) {
        this.noticeper = noticeper == null ? null : noticeper.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser == null ? null : touser.trim();
    }

    public String getCcuser() {
        return ccuser;
    }

    public void setCcuser(String ccuser) {
        this.ccuser = ccuser == null ? null : ccuser.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public Date getResolvetime() {
        return resolvetime;
    }

    public void setResolvetime(Date resolvetime) {
        this.resolvetime = resolvetime;
    }
}