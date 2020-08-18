package cn.cnic.security.xiandao.service.impl;

import cn.cnic.security.xiandao.dao.ServerInfoDao;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.Query;

import cn.cnic.security.xiandao.entity.ServerInfoEntity;
import cn.cnic.security.xiandao.service.ServerInfoService;


@Service("serverInfoService")
public class ServerInfoServiceImpl extends ServiceImpl<ServerInfoDao, ServerInfoEntity> implements ServerInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ServerInfoEntity> page = this.page(
                new Query<ServerInfoEntity>().getPage(params),
                new QueryWrapper<ServerInfoEntity>()
        );

        return new PageUtils(page);
    }

}