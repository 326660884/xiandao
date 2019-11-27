package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.mapper.ComputerPropertyMapper;
import cn.cnic.xiandao.model.ComputerProperty;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资产管理
 */

@RestController
public class PropertyInfo {

    @Autowired
    private ServiceImpl<ComputerPropertyMapper, ComputerProperty> Propertyservice;





}
