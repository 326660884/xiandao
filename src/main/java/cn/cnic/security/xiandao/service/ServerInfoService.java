package cn.cnic.security.xiandao.service;

import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.entity.ServerInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.Map;

/**
 * 物理服务器信息
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
public interface ServerInfoService extends IService<ServerInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

