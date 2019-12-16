package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.BroadcastNoticeMapper;
import cn.cnic.xiandao.model.BroadcastNotice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BroadcastNoticeImp extends ServiceImpl<BroadcastNoticeMapper,BroadcastNotice> {

    @Autowired
    TrackUserImpl trackUser;

    public void SendBrocast(String describeEvent){
        //获取发送对象,查询track_user
        List<String> nameList=trackUser.getAlluser();
        System.out.println(nameList);
        Date sendTime = new Date();

        //进行数据的插入
        for (String name:nameList
             ) {
            BroadcastNotice broadcastNotice = new BroadcastNotice(false,name,describeEvent,sendTime,null);
            baseMapper.insert(broadcastNotice);
        }
    }
}
