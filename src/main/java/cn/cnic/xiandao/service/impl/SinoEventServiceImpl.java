package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.ExhibitSinoEventMapper;
import cn.cnic.xiandao.model.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * exhit_sino_event dao
 */
@Service
public class SinoEventServiceImpl extends ServiceImpl<ExhibitSinoEventMapper, ExhibitSinoEvent> {

    //分页查询
    public Page getSpeciaresultUsePage (Integer page,Integer limit ){
        QueryWrapper<ExhibitSinoEvent> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.select("id","noticeunit","noticeemail","dateTime","eventName","eventType","eventFqcy",
                "eventLevel","sIpName","status","noticetime", "noticemethod", "describeevent","resolvetime");
        Page<ExhibitSinoEvent> ipage = new Page<>(page,limit);
        baseMapper.selectPage(ipage,queryWrapper);
        return ipage;
    }
    //移除功能，修改satus
    public UpdateWrapper<ExhibitSinoEvent> removeConditionWrapper(int id){
        //修改exhibitSinoEvent表status字段的状态；
        UpdateWrapper<ExhibitSinoEvent> updateWrapper = new UpdateWrapper<>();
        String SQL = "status=9 where id ="+id;
        updateWrapper.setSql(true, SQL);
        //将移除操作增加到Track_operation中
        return updateWrapper;
    }
    //edit功能修改status状态
    public UpdateWrapper<ExhibitSinoEvent> noticeAndmodifyStatus(int id){
        UpdateWrapper<ExhibitSinoEvent> updateWrapper = new UpdateWrapper<>();
        String SQL ="status = 1 where id = " + id;
        updateWrapper.setSql(true,SQL);

        return updateWrapper;
    }
    //edit功能修改status2状态   //注意时间
    public UpdateWrapper<ExhibitSinoEvent> noticeAndmodifyStatus(int id, String noticeUnit,String noticeMethod,  String describeEvent,String noticeTime) throws ParseException {
        UpdateWrapper<ExhibitSinoEvent> updateWrapper = new UpdateWrapper<>();
        String SQL ="status = 1,noticeUnit='"+noticeUnit + "',noticeMethod='"+noticeMethod+"',describeEvent='"+describeEvent+"',noticeTime='"+ noticeTime + "' where id = " + id;
        updateWrapper.setSql(true,SQL);

        return updateWrapper;
    }

    //解决功能修改status状态
    public UpdateWrapper<ExhibitSinoEvent> modifyStatus(int id) throws ParseException {
        //修改exhibitsinoEvent的status状态
        UpdateWrapper<ExhibitSinoEvent> updateWrapper = new UpdateWrapper<>();
        String resolveTime = new Date().toString();
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String SQL = "status = 2 ,resolveTime = '"+sdf2.format(sdf1.parse(resolveTime))+"' where id = " + id;
        updateWrapper.setSql(true,SQL);

        return updateWrapper;
    }
}
