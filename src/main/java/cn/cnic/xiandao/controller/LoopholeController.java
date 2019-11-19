package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.ResultVO;
import cn.cnic.xiandao.model.SimpleApiModel;
import cn.cnic.xiandao.model.TrackSecu;
import cn.cnic.xiandao.model.TrackSecuHistory;
import cn.cnic.xiandao.service.impl.LoopholeServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 漏洞预警（第四个菜单）
 */
@Slf4j
@RestController
@RequestMapping("loophole")
public class LoopholeController {

    @Autowired
    private LoopholeServiceImpl loopholeService;

    /**
     * 分页
     * @param limit
     * @param page
     * @return
     */
    @GetMapping("/list")
    public SimpleApiModel<TrackSecu> querySelect(Integer limit,Integer page){
        Page resutlPage = loopholeService.quertSelect(page, limit);
        SimpleApiModel<TrackSecu> res = SimpleApiModel.OK(resutlPage.getRecords(),resutlPage.getTotal());
        return res;
    }

    /**
     * 移除操作
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public SimpleApiModel<?> del(HttpServletRequest request ,@PathVariable("id")  int id){
        String username = (String)request.getSession().getAttribute("username");
        log.info("del <- ip:{},id:{},username:{}",request.getLocalAddr(),id,username);
        int i = loopholeService.remove(username,id);
        if(i > 0){
            log.info("track_secu表，逻辑移除成功。secuid={}",id);
            return SimpleApiModel.OK(id+"");
        }
        return SimpleApiModel.FAIL("移除失败");
    }


    /**
     *
     * @param request
     * @return
     */
    @PostMapping("")
    public SimpleApiModel<?> notice(HttpServletRequest request, TrackSecuHistory history){
        log.info("通报流程<--{}",history.toString());
        String username = (String)request.getSession().getAttribute("username");
        int i = loopholeService.insertAndUpdate(history, username);
        log.info("通报流程--操作结果={}",i);
        if(i == 1 ){
            return SimpleApiModel.OK("通报流程-操作成功");
        }else{
            return SimpleApiModel.FAIL("通报流程-操作失败");
        }
    }

    /**
     * 验证漏洞处理
     * @param request
     * @param map
     * @return
     */
    @PutMapping("")
    public SimpleApiModel<Object> testResult(HttpServletRequest request, @RequestBody Map<String,Object> map){
        log.info("验证漏洞处理<--{},ip:{}",map,request.getRemoteAddr());

        return SimpleApiModel.FAIL("1");
    }

}
