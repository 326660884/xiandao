package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.TrackUserMapper;
import cn.cnic.xiandao.model.TrackUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackUserImpl extends ServiceImpl<TrackUserMapper, TrackUser> {
    public List<String> getAlluser(){
        return baseMapper.getAlluser();
    }
}
