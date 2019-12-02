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

    public ResultVO(Integer code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
