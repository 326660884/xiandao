package cn.cnic.xiandao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("broadcast_notice")
public class BroadcastNotice {
    @TableId (value = "id",type = IdType.AUTO)
    private int id;

    private boolean ifread;
    private String username;
    private String noticecontent;
    private Date sendtime;
    private Date readtime;

    public BroadcastNotice(boolean ifread, String username, String noticecontent, Date senddateTime, Date readTime) {
        this.ifread = ifread;
        this.username = username;
        this.noticecontent = noticecontent;
        this.sendtime = senddateTime;
        this.readtime = readTime;
    }

}
