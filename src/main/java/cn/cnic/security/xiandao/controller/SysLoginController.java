package cn.cnic.security.xiandao.controller;

import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.xiandao.entity.SysLoginEntity;
import cn.cnic.security.xiandao.service.SysLoginService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.R;



/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 16:47:40
 */
@RestController
@RequestMapping("xiaodao/syslogin")
public class SysLoginController {
    @Autowired
    private SysLoginService sysLoginService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysLoginService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SysLoginEntity sysLogin = sysLoginService.getById(id);

        return R.ok().put("sysLogin", sysLogin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("xiaodao:syslogin:save")
    public R save(@RequestBody SysLoginEntity sysLogin){
		sysLoginService.save(sysLogin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("xiaodao:syslogin:update")
    public R update(@RequestBody SysLoginEntity sysLogin){
		sysLoginService.updateById(sysLogin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("xiaodao:syslogin:delete")
    public R delete(@RequestBody Integer[] ids){
		sysLoginService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
