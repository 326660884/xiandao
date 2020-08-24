package cn.cnic.security.xiandao.dao;

import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-13 18:19:44
 */
@Mapper
public interface UseRecordServerDao extends BaseMapper<UseRecordServerEntity> {

    List<UseRecordServerEntity> lastRecord();

}
