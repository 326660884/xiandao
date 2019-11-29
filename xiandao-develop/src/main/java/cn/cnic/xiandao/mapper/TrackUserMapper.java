package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackUser;

public interface TrackUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(TrackUser record);

    int insertSelective(TrackUser record);

    TrackUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TrackUser record);

    int updateByPrimaryKey(TrackUser record);
}