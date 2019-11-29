package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.ExhibitSinoEvent;
import cn.cnic.xiandao.model.ExhibitSinoEventWithBLOBs;

public interface ExhibitSinoEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExhibitSinoEventWithBLOBs record);

    int insertSelective(ExhibitSinoEventWithBLOBs record);

    ExhibitSinoEventWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKey(ExhibitSinoEvent record);
}