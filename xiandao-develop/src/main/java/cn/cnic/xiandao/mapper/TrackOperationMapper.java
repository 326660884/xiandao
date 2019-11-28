package cn.cnic.xiandao.mapper;

import cn.cnic.xiandao.model.TrackOperation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TrackOperationMapper extends BaseMapper<TrackOperation> {
    int deleteByPrimaryKey(Integer id);

    int insert(TrackOperation record);

    int insertSelective(TrackOperation record);

    TrackOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrackOperation record);

    int updateByPrimaryKey(TrackOperation record);
}