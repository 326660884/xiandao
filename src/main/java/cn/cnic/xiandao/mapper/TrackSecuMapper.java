package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackSecu;

public interface TrackSecuMapper {
    int deleteByPrimaryKey(Integer secuid);

    int insert(TrackSecu record);

    int insertSelective(TrackSecu record);

    TrackSecu selectByPrimaryKey(Integer secuid);

    int updateByPrimaryKeySelective(TrackSecu record);

    int updateByPrimaryKey(TrackSecu record);
}