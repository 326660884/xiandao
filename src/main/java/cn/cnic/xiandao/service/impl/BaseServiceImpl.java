package cn.cnic.xiandao.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> {


}
