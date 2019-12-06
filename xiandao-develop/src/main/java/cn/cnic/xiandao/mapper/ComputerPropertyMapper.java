package cn.cnic.xiandao.mapper;

import cn.cnic.xiandao.model.ComputerProperty;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface ComputerPropertyMapper extends BaseMapper<ComputerProperty> {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ComputerProperty record);

    ComputerProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComputerProperty record);

    int updateByPrimaryKey(ComputerProperty record);
}