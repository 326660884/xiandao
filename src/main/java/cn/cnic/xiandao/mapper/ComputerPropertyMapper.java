package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.ComputerProperty;

public interface ComputerPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComputerProperty record);

    int insertSelective(ComputerProperty record);

    ComputerProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComputerProperty record);

    int updateByPrimaryKey(ComputerProperty record);
}