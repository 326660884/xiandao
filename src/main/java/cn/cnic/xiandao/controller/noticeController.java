package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.model.BroadcastNotice;
import cn.cnic.xiandao.model.NoticePeople;
import cn.cnic.xiandao.model.ResultVO;
import cn.cnic.xiandao.service.impl.BroadcastNoticeImp;
import cn.cnic.xiandao.service.impl.EmailNotice;
import cn.cnic.xiandao.service.impl.NoticeServiceImpl;
import cn.cnic.xiandao.service.impl.SinoEventServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * notice_people
 *
 * request： notice;
 * function: toRemove
 * desc: insert data to the notice_people table,
 * together to update the exhibit_sino_event table ;
 *
 * request: togenerator
 * function: toRemove
 * desc: query the notice table data;
 */
@Controller
public class noticeController {

    @Autowired
    NoticeServiceImpl noticeService;

    @Autowired
    SinoEventServiceImpl sinoEventService;

    @Autowired
    EmailNotice emailnotice;

    @Autowired
    BroadcastNoticeImp broadcastNoticeImp;

    //通知
    @ResponseBody
    @RequestMapping("/notice")
    public String toRemove(String title, String noticeMethod, String describeEvent, Integer eid, Date noticeTime,String noticeEmail) throws ParseException {
        String noticeUnit = title;
        //notice表插入记录
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
        noticeService.insert(np);
        //修改exhibit_sino_event 的相关字段
        sinoEventService.update(sinoEventService.noticeAndmodifyStatus(eid,noticeUnit,noticeMethod,describeEvent,sdf2.format(sdf1.parse(dt))));

        if(noticeMethod.equals("021")){
            try {
                System.out.println("starting send email ... " + noticeEmail) ;
                emailnotice.constructMail(noticeUnit,noticeEmail,describeEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(noticeMethod.equals("0571")){
            System.out.println("send the broadcase");
            broadcastNoticeImp.SendBrocast(describeEvent);
        }
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

    @ResponseBody
    @RequestMapping("/getbroadcast")
    public ResultVO getBroadcast(String name) throws ParseException {
        System.out.println("get brocast notice");

        List<BroadcastNotice> bs=broadcastNoticeImp.getBrocastForUsename(name);

        broadcastNoticeImp.update(broadcastNoticeImp.updateSatusForIfread(name));

        ResultVO res = new ResultVO(1,"ok",bs);
        for (BroadcastNotice b:
             bs) {
            System.out.println(b.getUsername());
        }
        return res;
    }



}
