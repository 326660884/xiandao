package cn.cnic.security.xiandao.service.impl;

import cn.cnic.security.xiandao.common.utils.Constant;
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
        //判断是否警告
        Object warn = params.get("warn");
        QueryWrapper<UseRecordServerEntity> qw = new QueryWrapper<>();
        if( warn != null &&  Integer.parseInt(warn.toString()) == 1){
            qw.isNotNull("warn_type");
        }
        IPage<UseRecordServerEntity> page = this.page(
                new Query<UseRecordServerEntity>().getPage(params,"u_id",false),
                qw
        );

        return new PageUtils(page);
    }

}