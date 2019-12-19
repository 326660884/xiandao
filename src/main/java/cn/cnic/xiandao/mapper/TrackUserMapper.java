package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TrackUserMapper extends BaseMapper<TrackUser> {
    int deleteByPrimaryKey(Integer userid);

    int insert(TrackUser record);

    int insertSelective(TrackUser record);

    TrackUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TrackUser record);

    int updateByPrimaryKey(TrackUser record);

    @Select("Select userName from track_user")
    List<String> getAlluser();

}