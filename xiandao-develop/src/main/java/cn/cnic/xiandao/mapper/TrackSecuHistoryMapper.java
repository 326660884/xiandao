package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.TrackSecuHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TrackSecuHistoryMapper extends BaseMapper<TrackSecuHistory> {

    int deleteByPrimaryKey(Integer hid);

    int insertSelective(TrackSecuHistory record);

    TrackSecuHistory selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(TrackSecuHistory record);
}