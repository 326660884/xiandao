package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.ExhibiSinoEventWithNoticePeopleMapper;
import cn.cnic.xiandao.model.ExhibiSinoEventWithNoticePeople;
import cn.cnic.xiandao.model.ExhibitSinoEvent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SinoEventServiceWithNoticePeopleImpl extends ServiceImpl<ExhibiSinoEventWithNoticePeopleMapper, ExhibiSinoEventWithNoticePeople> {

    //分页查询
    public Page getSpeciaresultUsePage (Integer page,Integer limit ){

        QueryWrapper<ExhibiSinoEventWithNoticePeople> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        queryWrapper.select("id","noticeunit","noticeemail","dateTime","eventName","eventType","eventFqcy","eventLevel","sIpName","status");
        Page<ExhibiSinoEventWithNoticePeople> ipage = new Page<>(page,limit);
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
        System.out.println(SQL);
        updateWrapper.setSql(true,SQL);
        return updateWrapper;
    }

    //解决功能修改status状态
    public UpdateWrapper<ExhibitSinoEvent> modifyStatus(int id){
        //修改exhibitsinoEvent的status状态
        UpdateWrapper<ExhibitSinoEvent> updateWrapper = new UpdateWrapper<>();
        String SQL = "status = 2 where id = " + id;
        System.out.println(SQL);
        updateWrapper.setSql(true,SQL);


        return updateWrapper;
    }
}
