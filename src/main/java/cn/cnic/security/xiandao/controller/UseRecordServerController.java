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
//    @RequiresPermissions("xiandao:userecordserver:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = useRecordServerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uId}")
//    @RequiresPermissions("xiandao:userecordserver:info")
    public R info(@PathVariable("uId") Integer uId){
		UseRecordServerEntity useRecordServer = useRecordServerService.getById(uId);

        return R.ok().put("useRecordServer", useRecordServer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("xiandao:userecordserver:save")
    public R save(@RequestBody UseRecordServerEntity useRecordServer){
		useRecordServerService.save(useRecordServer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("xiandao:userecordserver:update")
    public R update(@RequestBody UseRecordServerEntity useRecordServer){
		useRecordServerService.updateById(useRecordServer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("xiandao:userecordserver:delete")
    public R delete(@RequestBody Integer[] uIds){
		useRecordServerService.removeByIds(Arrays.asList(uIds));

        return R.ok();
    }

}
