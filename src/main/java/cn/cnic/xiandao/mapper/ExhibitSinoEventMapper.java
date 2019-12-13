package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.ExhibitSinoEvent;
import cn.cnic.xiandao.model.ExhibitSinoEventWithBLOBs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface ExhibitSinoEventMapper extends BaseMapper<ExhibitSinoEvent> {
    int deleteByPrimaryKey(Integer id);

    int insert(ExhibitSinoEventWithBLOBs record);

    int insertSelective(ExhibitSinoEventWithBLOBs record);

    ExhibitSinoEventWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKey(ExhibitSinoEvent record);
}