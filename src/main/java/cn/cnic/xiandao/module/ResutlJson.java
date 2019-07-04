package cn.cnic.xiandao.module;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ResutlJson<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public static <T> ResutlJson OK(){
        ResutlJson<T> r = new ResutlJson<>();
        r.setCode(0);
        return r;

    }
    public static <T> ResutlJson OK(String msg){
        ResutlJson<T> r =OK();
        r.setMsg(msg);
        return r;
    }

    public static <T> ResutlJson FAIL(String msg){
        ResutlJson<T> r = OK(msg);
        r.setCode(-1);
        return r;
    }


}
