package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.ExhibiSinoEventWithNoticePeople;
import cn.cnic.xiandao.model.ExhibitSinoEvent;
import cn.cnic.xiandao.model.ResultVO;
import cn.cnic.xiandao.model.ResultVOSinoEvent;
import cn.cnic.xiandao.service.impl.SinoEventServiceImpl;
import cn.cnic.xiandao.service.impl.SinoEventServiceWithNoticePeopleImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * safe event
 *
 * request:getSecurityincidentsUsePage
 * function:getSecurityincidentsUsePage
 * desc: using the split page for the data of query
 *
 * request:remove
 * function:remove
 * desc: according to the id ,to update the  status value of the exhibit_sino_event table;
 *
 * request:toresolve
 * function:modifyStatus
 * desc:according to the id ,to update the  status value of the exhibit_sino_event table;
 *
 */

@Controller
public class SinoEventController {

    @Autowired
    SinoEventServiceImpl sinoEventService;
    @Autowired
    SinoEventServiceWithNoticePeopleImpl sinoEventServiceWithNoticePeople;
    //分页操作
    @ResponseBody()
    @RequestMapping("/getSecurityincidentsUsePage")
    public ResultVOSinoEvent<ExhibitSinoEvent> getSecurityincidentsUsePage(Integer limit, Integer page){
        Page pageResult = sinoEventService.getSpeciaresultUsePage(page,limit);
        ResultVOSinoEvent<ExhibitSinoEvent> resultVOSinoEvent=
                new ResultVOSinoEvent<ExhibitSinoEvent>(Integer.valueOf(0),"操作成功",Long.valueOf(pageResult.getTotal()),pageResult.getRecords());

        return  resultVOSinoEvent;
    }
    //分页操作,暂时没用到，进行多表连接进行分页
    @ResponseBody()
    @RequestMapping("/getSecurityincidentsUsePageWithNotice")
    public ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople> getSecurityincidentsUsePageWithNotice(Integer limit, Integer page){
        Page pageResult = sinoEventServiceWithNoticePeople.getSpeciaresultUsePage(page,limit);
        ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople> resultVOSinoEvent=
                new ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople>(Integer.valueOf(0),"操作成功",Long.valueOf(pageResult.getTotal()),pageResult.getRecords());
        return  resultVOSinoEvent;
    }
    //移除操作，更新exhibit_sino_event的status字段；
    @RequestMapping("/remove")
    @ResponseBody
    public ResultVO remove(int id) {
        sinoEventService.update(sinoEventService.removeConditionWrapper(id));
        ResultVO res = new ResultVO(1,"ok",null);
        return res;
    }
    //解决操作，更新exhibit_sino_event的status字段
    @RequestMapping("/toresolve")
    @ResponseBody
    public ResultVO modifyStatus(int id) throws ParseException {
        sinoEventService.update(sinoEventService.modifyStatus(id));
        ResultVO res = new ResultVO(1,"ok",null);
         return res;
    }

    @ResponseBody
    @RequestMapping("/tovalidateUser")
    public ResultVO tovalidateUser(String notice){
        QueryWrapper<ExhibitSinoEvent> queryWrapper = new QueryWrapper<>();
        List<Map<String, Object>> list =  sinoEventService.listMaps(queryWrapper.select("noticeUnit"));
        ResultVO res = null;
        for(Map<String,Object> obj : list){
            String str = obj.values().toString().substring(1,obj.values().toString().length()-1);
            if(notice.equals(str)){
                res = new ResultVO<>(1,"ok",null);
                return res;
            }
        }
        res = new ResultVO(1,"nok",null);
        return res;
    }
}
