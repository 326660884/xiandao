package cn.cnic.xiandao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
    @TableId(type=IdType.INPUT)
    private Long id;
    private String name;

}
