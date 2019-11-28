package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.NoticePeopleMapper;
import cn.cnic.xiandao.model.NoticePeople;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class NoticeServiceImpl extends ServiceImpl<NoticePeopleMapper, NoticePeople> {
    public void insert(NoticePeople np){
        baseMapper.insert(np);
    }
}
