package cn.cnic.security.xiandao.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.Query;

import cn.cnic.security.xiandao.dao.UseRecordServerDao;
import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import cn.cnic.security.xiandao.service.UseRecordServerService;


@Service("useRecordServerService")
public class UseRecordServerServiceImpl extends ServiceImpl<UseRecordServerDao, UseRecordServerEntity> implements UseRecordServerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UseRecordServerEntity> page = this.page(
                new Query<UseRecordServerEntity>().getPage(params),
                new QueryWrapper<UseRecordServerEntity>()
        );

        return new PageUtils(page);
    }

}