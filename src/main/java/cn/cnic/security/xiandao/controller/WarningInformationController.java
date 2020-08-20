package cn.cnic.security.xiandao.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.xiandao.entity.WarningInformationEntity;
import cn.cnic.security.xiandao.service.WarningInformationService;
import cn.cnic.security.xiandao.common.utils.PageUtils;
import cn.cnic.security.xiandao.common.utils.R;



/**
 * 
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-08-18 18:26:15
 */
@RestController
@RequestMapping("xiaodao/warninginformation")
public class WarningInformationController {
    @Autowired
    private WarningInformationService warningInformationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("xiaodao:warninginformation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = warningInformationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{wId}")
//    @RequiresPermissions("xiaodao:warninginformation:info")
    public R info(@PathVariable("wId") Integer wId){
		WarningInformationEntity warningInformation = warningInformationService.getById(wId);

        return R.ok().put("warningInformation", warningInformation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("xiaodao:warninginformation:save")
    public R save(@RequestBody WarningInformationEntity warningInformation){
		warningInformationService.save(warningInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("xiaodao:warninginformation:update")
    public R update(@RequestBody WarningInformationEntity warningInformation){
		warningInformationService.updateById(warningInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("xiaodao:warninginformation:delete")
    public R delete(@RequestBody Integer[] wIds){
		warningInformationService.removeByIds(Arrays.asList(wIds));

        return R.ok();
    }

}
