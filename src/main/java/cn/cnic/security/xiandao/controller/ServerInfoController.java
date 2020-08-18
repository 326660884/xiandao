package cn.cnic.security.xiandao.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.xiandao.entity.ServerInfoEntity;
import cn.cnic.security.xiandao.service.ServerInfoService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.R;



/**
 * 物理服务器信息
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
@RestController
@RequestMapping("xiaodao/serverinfo")
public class ServerInfoController {
    @Autowired
    private ServerInfoService serverInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("xiaodao:serverinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = serverInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sid}")
//    @RequiresPermissions("xiaodao:serverinfo:info")
    public R info(@PathVariable("sid") Integer sid){
		ServerInfoEntity serverInfo = serverInfoService.getById(sid);

        return R.ok().put("serverInfo", serverInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("xiaodao:serverinfo:save")
    public R save(@RequestBody ServerInfoEntity serverInfo){
		serverInfoService.save(serverInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("xiaodao:serverinfo:update")
    public R update(@RequestBody ServerInfoEntity serverInfo){
		serverInfoService.updateById(serverInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("xiaodao:serverinfo:delete")
    public R delete(@RequestBody Integer[] sids){
		serverInfoService.removeByIds(Arrays.asList(sids));

        return R.ok();
    }

}
