package cn.cnic.security.xiandao.dao;

import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

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

    /**
     * 左连接查询，加入课题归属topic
     * @param page
     * @param wrapper
     * @return
     */
    IPage<UseRecordServerEntity> selectPageByTopic(IPage<UseRecordServerEntity> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 统计topic个数
     * @param wrapper
     * @return
     */
    List<Map<String, Object>> groupByTopic(@Param(Constants.WRAPPER) Wrapper wrapper);
}
