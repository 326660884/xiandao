package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.mapper.TrackSecuMapper;
import cn.cnic.xiandao.model.SimpleApiModel;
import cn.cnic.xiandao.model.TrackSecu;
import cn.cnic.xiandao.model.TrackSecuHistory;
import cn.cnic.xiandao.service.impl.LoopholeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
     *
     * @param limit
     * @param page
     * @return
     */
    @GetMapping("/list")
    public SimpleApiModel<TrackSecu> querySelect(Integer limit, Integer page) {
        Page resutlPage = loopholeService.quertSelect(page, limit);
        SimpleApiModel<TrackSecu> res = SimpleApiModel.OK(resutlPage.getRecords(), resutlPage.getTotal());
        return res;
    }

    /**
     * 移除操作
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public SimpleApiModel<?> del(HttpServletRequest request, @PathVariable("id") int id) {
        String username = (String) request.getSession().getAttribute("username");
        log.info("del <- ip:{},id:{},username:{}", request.getLocalAddr(), id, username);
        int i = loopholeService.remove(username, id);
        if (i > 0) {
            log.info("track_secu表，逻辑移除成功。secuid={}", id);
            return SimpleApiModel.OK(id + "");
        }
        return SimpleApiModel.FAIL("移除失败");
    }


    /**
     * @param request
     * @return
     */
    @PostMapping("")
    public SimpleApiModel<?> notice(HttpServletRequest request, TrackSecuHistory history) {
        log.info("通报流程<--{}", history.toString());
        String username = (String) request.getSession().getAttribute("username");
        int i = loopholeService.insertAndUpdate(history, username);
        log.info("通报流程--操作结果={}", i);
        if (i == 1) {
            return SimpleApiModel.OK("通报流程-操作成功");
        } else {
            return SimpleApiModel.FAIL("通报流程-操作失败");
        }
    }

    /**
     * 验证漏洞处理
     *
     * @param request
     * @param map
     * @return
     */
    @PutMapping("")
    public SimpleApiModel<Object> testResult(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        log.info("验证漏洞处理<--{},ip:{}", map, request.getRemoteAddr());
        int i = loopholeService.solve(map);
        return i == 1 ? SimpleApiModel.OK("成功") : SimpleApiModel.FAIL("" + map.get("secuid"));
    }

    /**
     * 查看在线
     *
     * @param id
     * @return
     */
    @GetMapping("report/{id}")
    public ModelAndView report(@PathVariable("id") int id) {
        log.info("/report/{}", id);
        ModelAndView mv = new ModelAndView("earlywarning_report");
        TrackSecuMapper baseMapper = loopholeService.getBaseMapper();
        TrackSecu trackSecu = baseMapper.selectById(id);
        if (trackSecu != null && trackSecu.getStatusCode() != null && trackSecu.getStatusCode() == 2) {
            mv.addObject("t", trackSecu);
            QueryWrapper<TrackSecuHistory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sid", trackSecu.getSecuid());
            List<TrackSecuHistory> list = loopholeService.getHistoryMapper().selectList(queryWrapper);
            log.info("在线查看 {}",list);
            mv.addObject("h",list.get(0));
        }

        return mv;
    }
}
