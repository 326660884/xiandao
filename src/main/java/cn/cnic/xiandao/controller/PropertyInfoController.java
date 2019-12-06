package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.mapper.ComputerPropertyMapper;
import cn.cnic.xiandao.model.ComputerProperty;
import cn.cnic.xiandao.model.SimpleApiModel;
import cn.cnic.xiandao.model.TrackSecu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 资产管理
 */
@Slf4j
@RestController
public class PropertyInfoController {

    @Autowired
    private ServiceImpl<ComputerPropertyMapper, ComputerProperty> serviceImpl;


    @GetMapping("propertyinfo")
    public SimpleApiModel<ComputerProperty> pagingQuery(Integer limit, Integer page){
        QueryWrapper<ComputerProperty> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        //页码
        Page<ComputerProperty> ipage = new Page<>(page==null?1:page,limit==null?10:limit);
        IPage<ComputerProperty> page1 = serviceImpl.page(ipage, queryWrapper);
        SimpleApiModel<ComputerProperty> ok = SimpleApiModel.OK(ipage.getRecords(), ipage.getTotal());
        return ok;
    }

    @GetMapping("propertyMessage")
    public ModelAndView propertyMessage(){
        ModelAndView mv = new ModelAndView("property_message");
        return mv;
    }





}
