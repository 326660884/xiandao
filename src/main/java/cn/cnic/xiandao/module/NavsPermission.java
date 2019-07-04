package cn.cnic.xiandao.module;


import lombok.Data;

import java.util.List;
@Data
public class NavsPermission<T> extends SysPermission {

    private String title;
    private List<T> children;
    private Integer id;
}
