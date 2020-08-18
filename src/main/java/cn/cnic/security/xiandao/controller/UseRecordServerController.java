package cn.cnic.security.xiandao.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import cn.cnic.security.xiandao.service.UseRecordServerService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.R;



/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-13 18:19:44
 */
@RestController
@RequestMapping("userecordserver")
public class UseRecordServerController {
    @Autowired
    private UseRecordServerService useRecordServerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        if(params == null){
            params = new HashMap<>();
        }
        PageUtils page = useRecordServerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
//    @RequestMapping("/info/{uId}")
    public R info(@PathVariable("uId") Integer uId){
		UseRecordServerEntity useRecordServer = useRecordServerService.getById(uId);
        return R.ok().put("useRecordServer", useRecordServer);
    }
}
