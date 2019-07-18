package cn.cnic.xiandao.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private List<T> data;

}
