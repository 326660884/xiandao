package cn.cnic.security.xiandao.service.impl;

import cn.cnic.security.xiandao.common.utils.R;
import cn.cnic.security.xiandao.dao.UseRecordServerDao;
import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    private ServerInfoServiceImpl serverInfoService;

    @Autowired
    private UseRecordServerServiceImpl useRecordServerService;

    @Autowired
    private WarningInformationServiceImpl warningInformationService;

    @Autowired
    private UseRecordServerDao useRecordServerDao;


    /**
     * 总体运行状态
     * @return
     */
    public Map<String , Integer> Overall(){
        HashMap<String , Integer> map = new HashMap<>(4);
        int count = serverInfoService.count();
        map.put("serverTotal",count);
        List<UseRecordServerEntity> list = useRecordServerDao.lastRecord();
        int warnNum = 0;
        for(UseRecordServerEntity entity:list){
            if(StringUtils.isEmpty(entity.getWarnType()))
                warnNum++;
        }
        map.put("serverWarnNum",warnNum);
        //不在线都是故障的
        map.put("serverFaultNum",count-list.size());
        return map;
    }

    /**
     * 集群 平均值
     * @return
     */
    public UseRecordServerEntity average(){
        UseRecordServerEntity average = new UseRecordServerEntity();
        List<UseRecordServerEntity> list = useRecordServerDao.lastRecord();

        for(UseRecordServerEntity entity:list){
           average.setMemory( average.getMemory() + entity.getMemory());
           average.setCpuUse( average.getCpuUse() + entity.getCpuUse() );
           
        }



        return average;
    }

}
