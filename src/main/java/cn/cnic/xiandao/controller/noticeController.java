package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.model.NoticePeople;
import cn.cnic.xiandao.service.impl.NoticeServiceImpl;
import cn.cnic.xiandao.service.impl.SinoEventServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Controller
public class noticeController {

    @Autowired
    NoticeServiceImpl noticeService;

    @Autowired
    SinoEventServiceImpl sinoEventService;
    //通知
    @ResponseBody
    @RequestMapping("/notice")
    public String toRemove(String noticeUnit, String noticeMethod, String describeEvent, Integer eid, Date noticeTime) throws ParseException {
        //插入通报信息
        System.out.println("获取表单的参数为: " + noticeUnit);
        NoticePeople np = new NoticePeople();
        np.setNoticemethod(noticeMethod);
        np.setNoticeunit(noticeUnit);
        np.setDescribeevent(describeEvent);
        np.setEid(eid);
        np.setNoticetime(noticeTime);
        //时间转换为特定时间
        String dt=noticeTime.toString();
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(sdf1.parse(dt)));
        noticeService.insert(np);
        //修改状态
        sinoEventService.update(sinoEventService.noticeAndmodifyStatus(eid,noticeMethod,describeEvent,sdf2.format(sdf1.parse(dt))));


        return "ok";
    }

    //通知
    @ResponseBody
    @RequestMapping("/togenerator")
    public String toRemove(Integer eid){
        //查询通报信息


        QueryWrapper<NoticePeople> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("noticeTime ");


        return "ok";
    }


}
