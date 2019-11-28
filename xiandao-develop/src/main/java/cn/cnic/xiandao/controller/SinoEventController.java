package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.ExhibiSinoEventWithNoticePeople;
import cn.cnic.xiandao.model.ExhibitSinoEvent;
import cn.cnic.xiandao.model.ResultVO;
import cn.cnic.xiandao.model.ResultVOSinoEvent;
import cn.cnic.xiandao.service.impl.SinoEventServiceImpl;
import cn.cnic.xiandao.service.impl.SinoEventServiceWithNoticePeopleImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


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
    //分页2操作,暂时没用到
    @ResponseBody()
    @RequestMapping("/getSecurityincidentsUsePageWithNotice")
    public ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople> getSecurityincidentsUsePageWithNotice(Integer limit, Integer page){


        Page pageResult = sinoEventServiceWithNoticePeople.getSpeciaresultUsePage(page,limit);
        ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople> resultVOSinoEvent=
                new ResultVOSinoEvent<ExhibiSinoEventWithNoticePeople>(Integer.valueOf(0),"操作成功",Long.valueOf(pageResult.getTotal()),pageResult.getRecords());

        return  resultVOSinoEvent;
    }

    //移除
    @RequestMapping("/remove")
    @ResponseBody
    public ResultVO remove(int id) {
        System.out.println(id);
        sinoEventService.update(sinoEventService.removeConditionWrapper(id));
        ResultVO res = new ResultVO(1,"ok",null);
        System.out.println(res);

        return res;
    }
    //解决
    @RequestMapping("/toresolve")
    @ResponseBody
    public ResultVO modifyStatus(int id) throws ParseException {
        sinoEventService.update(sinoEventService.modifyStatus(id));
        ResultVO res = new ResultVO(1,"ok",null);
        System.out.println(res);
        return res;
    }

}
