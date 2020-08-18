package cn.cnic.security.xiandao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.entity.SysLoginEntity;

import java.util.Map;

/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
public interface SysLoginService extends IService<SysLoginEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

