package cn.cnic.xiandao.model;

public class ExhibitSinoEventWithBLOBs extends ExhibitSinoEvent {
    private String whois;

    private String sendhtml;

    public String getWhois() {
        return whois;
    }

    public void setWhois(String whois) {
        this.whois = whois == null ? null : whois.trim();
    }

    public String getSendhtml() {
        return sendhtml;
    }

    public void setSendhtml(String sendhtml) {
        this.sendhtml = sendhtml == null ? null : sendhtml.trim();
    }
}