package cn.cnic.xiandao.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ResultVOSinoEvent<T> extends ResultVO<T> {
    private Long count;  //数量


    public ResultVOSinoEvent(Integer code, String msg, Long count,List<T> data ) {
        super(code, msg, data);
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
