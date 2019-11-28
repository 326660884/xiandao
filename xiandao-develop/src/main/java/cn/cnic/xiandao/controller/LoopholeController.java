package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.SimpleApiModel;
import cn.cnic.xiandao.model.TrackSecu;
import cn.cnic.xiandao.service.impl.LoopholeServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 漏洞
 */
@RestController
@RequestMapping("loophole")
public class LoopholeController {

    @Autowired
    private LoopholeServiceImpl loopholeService;

    @GetMapping("/list")
    public SimpleApiModel<TrackSecu> querySelect(Integer limit, Integer page){
        Page resutlPage = loopholeService.quertSelect(page, limit);
        SimpleApiModel<TrackSecu> res = SimpleApiModel.OK(resutlPage.getRecords(),resutlPage.getTotal());
        return res;
    }


}
