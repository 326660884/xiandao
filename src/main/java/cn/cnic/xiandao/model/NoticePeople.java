package cn.cnic.xiandao.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("notice_people")
@Data
public class NoticePeople {

    @TableId(value = "nid")
    private int nid;

    private int eid;
    private Date noticetime;
    private String aipname;
    private String noticemethod;
    private String describeevent;


}
