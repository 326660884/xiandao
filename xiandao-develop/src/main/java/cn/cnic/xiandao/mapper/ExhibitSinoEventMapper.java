package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.ExhibitSinoEvent;
import cn.cnic.xiandao.model.ExhibitSinoEventWithBLOBs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface ExhibitSinoEventMapper extends BaseMapper<ExhibitSinoEvent> {
    int deleteByPrimaryKey(Integer id);

    int insert(ExhibitSinoEventWithBLOBs record);

    int insertSelective(ExhibitSinoEventWithBLOBs record);

    ExhibitSinoEventWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExhibitSinoEventWithBLOBs record);

    int updateByPrimaryKey(ExhibitSinoEvent record);

    @Select("select * from exhibit_sino_event LEFT JOIN notice_people ON exhibit_sino_event.id = notice_people.eid ;")
    int selectWithNoticePeople(Page<Map<String,Object>> page);



}