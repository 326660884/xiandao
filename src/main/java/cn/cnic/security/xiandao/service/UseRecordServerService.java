package cn.cnic.security.xiandao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.entity.UseRecordServerEntity;

import java.util.Map;

/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-13 18:19:44
 */
public interface UseRecordServerService extends IService<UseRecordServerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

