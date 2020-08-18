package cn.cnic.security.xiandao.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.Query;

import cn.cnic.security.xiandao.dao.SysLoginDao;
import cn.cnic.security.xiandao.entity.SysLoginEntity;
import cn.cnic.security.xiandao.service.SysLoginService;


@Service("sysLoginService")
public class SysLoginServiceImpl extends ServiceImpl<SysLoginDao, SysLoginEntity> implements SysLoginService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysLoginEntity> page = this.page(
                new Query<SysLoginEntity>().getPage(params),
                new QueryWrapper<SysLoginEntity>()
        );

        return new PageUtils(page);
    }

}