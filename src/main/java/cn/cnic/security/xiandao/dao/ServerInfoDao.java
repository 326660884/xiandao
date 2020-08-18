package cn.cnic.security.xiandao.dao;

import cn.cnic.security.xiandao.entity.ServerInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物理服务器信息
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
@Mapper
public interface ServerInfoDao extends BaseMapper<ServerInfoEntity> {
	
}
