package cn.cnic.security.xiandao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.entity.WarningInformationEntity;

import java.util.Map;

/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 18:26:15
 */
public interface WarningInformationService extends IService<WarningInformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

