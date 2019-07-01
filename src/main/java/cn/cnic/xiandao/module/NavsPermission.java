package cn.cnic.xiandao.module;


import lombok.Data;

import java.util.List;
@Data
public class NavsPermission extends SysPermission {

    private String title;
    private List<ISysPermission> children;


}
