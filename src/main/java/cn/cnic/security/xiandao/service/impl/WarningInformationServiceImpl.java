package cn.cnic.security.xiandao.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.Query;

import cn.cnic.security.xiandao.dao.WarningInformationDao;
import cn.cnic.security.xiandao.entity.WarningInformationEntity;
import cn.cnic.security.xiandao.service.WarningInformationService;


@Service("warningInformationService")
public class WarningInformationServiceImpl extends ServiceImpl<WarningInformationDao, WarningInformationEntity> implements WarningInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WarningInformationEntity> page = this.page(
                new Query<WarningInformationEntity>().getPage(params),
                new QueryWrapper<WarningInformationEntity>()
        );

        return new PageUtils(page);
    }

}