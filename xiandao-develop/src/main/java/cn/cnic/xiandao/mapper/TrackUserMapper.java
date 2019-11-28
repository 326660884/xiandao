package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TrackUserMapper extends BaseMapper<TrackUser> {
    int deleteByPrimaryKey(Integer userid);

    int insert(TrackUser record);

    int insertSelective(TrackUser record);

    TrackUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TrackUser record);

    int updateByPrimaryKey(TrackUser record);
}