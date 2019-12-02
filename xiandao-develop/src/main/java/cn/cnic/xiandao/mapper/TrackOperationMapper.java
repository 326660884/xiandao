package cn.cnic.xiandao.mapper;

import cn.cnic.xiandao.model.TrackOperation;

public interface TrackOperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrackOperation record);

    int insertSelective(TrackOperation record);

    TrackOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrackOperation record);

    int updateByPrimaryKey(TrackOperation record);
}