package cn.cnic.xiandao.service.impl;

import cn.cnic.xiandao.mapper.TrackSecuHistoryMapper;
import cn.cnic.xiandao.mapper.TrackSecuMapper;
import cn.cnic.xiandao.model.TrackSecu;
import cn.cnic.xiandao.model.TrackSecuHistory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 漏洞信息
 */
@Service
public class LoopholeServiceImpl extends ServiceImpl<TrackSecuMapper, TrackSecu> {

    @Autowired
    private TrackSecuHistoryMapper historyMapper;

    public Page quertSelect(Integer page,Integer limit ){
        //分页条件
        QueryWrapper<TrackSecu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("createTime");
        queryWrapper.gt("createTime","2019-01-01 00:00:00");
        //页码
        Page<TrackSecu> ipage = new Page<>(page,limit);
        baseMapper.selectPage(ipage, queryWrapper);
        return ipage;
    }

    /**
     * 逻辑移除
     * @param username
     * @param id
     * @return
     */
    public Integer remove(String username, Integer id){
        TrackSecu trackSecu = new TrackSecu();
        trackSecu.setUpdatetime(new Date());
        trackSecu.setUpdateuser(username);
        trackSecu.setIsDel("1");
        trackSecu.setStatusCode(9);
        trackSecu.setSecuid(id);
        return  baseMapper.updateById(trackSecu);
    }

    @Transactional
    public int insertAndUpdate(TrackSecuHistory history, String username) {
        TrackSecu trackSecu = baseMapper.selectById(history.getSid());
        if(trackSecu == null){
            return -1;
        }
        //保存历史信息
        Integer integer = trackSecu.getStatusCode();

        int insert = historyMapper.insert(history);
        trackSecu.setStatusCode(1);
        trackSecu.setUpdateuser(username);
        trackSecu.setUpdatetime(new Date());
        int i = baseMapper.updateById(trackSecu);//更新状态
        return i == insert ?1:-1;
    }
}
