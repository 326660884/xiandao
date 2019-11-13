package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackSecu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TrackSecuMapper extends BaseMapper<TrackSecu> {

    int deleteByPrimaryKey(Integer secuid);

    int insertSelective(TrackSecu record);

    TrackSecu selectByPrimaryKey(Integer secuid);

    int updateByPrimaryKeySelective(TrackSecu record);

    int updateByPrimaryKey(TrackSecu record);
}