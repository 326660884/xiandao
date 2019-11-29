package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackNotice;

public interface TrackNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrackNotice record);

    int insertSelective(TrackNotice record);

    TrackNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrackNotice record);

    int updateByPrimaryKey(TrackNotice record);
}