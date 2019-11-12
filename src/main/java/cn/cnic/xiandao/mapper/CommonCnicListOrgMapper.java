package cn.cnic.xiandao.mapper;


import cn.cnic.xiandao.model.CommonCnicListOrg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CommonCnicListOrgMapper extends BaseMapper<CommonCnicListOrg> {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonCnicListOrg record);

    int insertSelective(CommonCnicListOrg record);

    CommonCnicListOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonCnicListOrg record);

    int updateByPrimaryKey(CommonCnicListOrg record);
}