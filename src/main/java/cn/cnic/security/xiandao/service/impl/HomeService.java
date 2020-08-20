package cn.cnic.security.xiandao.service.impl;

import cn.cnic.security.xiandao.common.utils.R;
import cn.cnic.security.xiandao.dao.UseRecordServerDao;
import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import cn.cnic.security.xiandao.entity.WarningInformationEntity;
import javafx.beans.binding.ObjectExpression;
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
     * @return Map
     */
    public Map<String , Integer> overall(){
        HashMap<String , Integer> map = new HashMap<>(4);
        int count = serverInfoService.count();
        map.put("serverTotal",count);
        List<UseRecordServerEntity> list = useRecordServerDao.lastRecord();
        int warnNum = 0;
        for(UseRecordServerEntity entity:list){
            if(!StringUtils.isEmpty(entity.getWarnType()))
                warnNum++;
        }
        map.put("serverWarnNum",warnNum);
        //不在线都是故障的
        map.put("serverFaultNum",count-list.size());
        return map;
    }

    /**
     * 集群 平均值
     * @return UseRecordServerEntity
     */
    public UseRecordServerEntity average(){
        UseRecordServerEntity average = new UseRecordServerEntity();
        List<UseRecordServerEntity> list = useRecordServerDao.lastRecord();
        //各个指标相加
        for(UseRecordServerEntity entity:list){
           average.setMemory( average.getMemory() + entity.getMemory());
           average.setCpuUse( average.getCpuUse() + entity.getCpuUse() );
           average.setResponseTime( average.getResponseTime() + entity.getResponseTime() );
           average.setQueryRate( average.getQueryRate() + entity.getQueryRate() );
           average.setDiskUse( average.getDiskUse() + entity.getDiskUse() );
           average.setDiskSpeed( average.getDiskSpeed() + entity.getDiskSpeed() );
           average.setBandwidth( average.getBandwidth() + entity.getBandwidth() );
           average.setBandwinthDown( average.getBandwinthDown() + entity.getBandwinthDown() );
           average.setProcessesNumber(average.getProcessesNumber() + entity.getProcessesNumber());
        }
        //求平均值
        average.setMemory( average.getMemory() / list.size());
        average.setCpuUse( average.getCpuUse() / list.size() );
        average.setResponseTime( average.getResponseTime() / list.size() );
        average.setQueryRate( average.getQueryRate() / list.size() );
        average.setDiskUse( average.getDiskUse() / list.size() );
        average.setDiskSpeed( average.getDiskSpeed() / list.size() );
        average.setBandwidth( average.getBandwidth() / list.size() );
        average.setBandwinthDown( average.getBandwinthDown() / list.size() );
        average.setProcessesNumber(average.getProcessesNumber() / list.size() );

        return average;
    }

    /**
     * 告警类型数量
      * @return
     */
    public Map<String , Integer> wranTypeNum(){
        List<WarningInformationEntity> list = warningInformationService.list();
        HashMap<String , Integer> map = new HashMap<>(list.size());
        for (WarningInformationEntity e:list)
            map.put(e.getWarnType(),new Integer(0));

        //
        List<UseRecordServerEntity> lastRecordList = useRecordServerDao.lastRecord();
        for (UseRecordServerEntity e : lastRecordList){
            String warnType = e.getWarnType();
            if(!StringUtils.isEmpty(warnType)){
                map.compute(warnType,(k,v)->{
                   if(v == null){
                       v = new Integer(0);
                   }else {
                       v += 1;
                   }
                    return v;
                });
            }
        }
        return map;
    }

}
