package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TrackNoticeMapper extends BaseMapper<TrackNotice> {
    int deleteByPrimaryKey(Integer id);

    int insert(TrackNotice record);

    int insertSelective(TrackNotice record);

    TrackNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrackNotice record);

    int updateByPrimaryKey(TrackNotice record);
}