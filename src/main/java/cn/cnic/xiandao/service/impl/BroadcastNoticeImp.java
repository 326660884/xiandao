package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.BroadcastNoticeMapper;
import cn.cnic.xiandao.model.BroadcastNotice;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    //根据username查询未读的通知，即ifread = 0;//更改通知信息，标注为已读，即更新ifread = 0
    public List<BroadcastNotice> getBrocastForUsename(String username) throws ParseException {

        QueryWrapper<BroadcastNotice> queryWrapper = new QueryWrapper();
        QueryWrapper result =queryWrapper.eq(true, "ifRead","0");
        result.eq(true,"username",username);
        result.select("id,username,noticeContent");

        List<BroadcastNotice> ls = baseMapper.selectList(result);

        updateSatusForIfread(username);

        return ls;
    }
    //更改通知信息，标注为已读，即更新ifread = 0
    public UpdateWrapper updateSatusForIfread(String username) throws ParseException {

        UpdateWrapper updateWrapper = new UpdateWrapper();
        String readTime = new Date().toString();
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "readTime= '"+ sdf2.format(sdf1.parse(readTime)) + "',ifRead = '"+1+ "' where userName = '"+ username+"'";
        updateWrapper.setSql(true,sql);

        return updateWrapper;
     }


}
