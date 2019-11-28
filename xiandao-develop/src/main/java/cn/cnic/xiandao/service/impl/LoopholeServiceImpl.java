package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.TrackSecuMapper;
import cn.cnic.xiandao.model.TrackSecu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 漏洞信息
 */
@Service
public class LoopholeServiceImpl extends ServiceImpl<TrackSecuMapper, TrackSecu> {

    public Page quertSelect(Integer page,Integer limit ){
        //分页条件
        QueryWrapper<TrackSecu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("secuid");
        //页码
        Page<TrackSecu> ipage = new Page<>(page,limit);
        baseMapper.selectPage(ipage, queryWrapper);
        return ipage;
    }

}
