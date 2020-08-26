package cn.cnic.security.xiandao.controller;

import cn.cnic.security.xiandao.common.utils.R;
import cn.cnic.security.xiandao.entity.UseRecordServerEntity;
import cn.cnic.security.xiandao.service.impl.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 用于显示DK网页的请求
 * @author xu
 */
@RestController
@RequestMapping("dkhome/")
public class DKhomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("overall")
    public R overall(){
        Map<String, Integer> map = this.homeService.overall();
        R r = R.ok();
        r.putAll(map);
        return r;
    }

    @GetMapping("average")
    public R average(){
        UseRecordServerEntity average = homeService.average();
        try {
            return R.convertBeanToR(average,R.ok());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return R.error();
    }


    @GetMapping("wranTypeNum")
    public R wranTypeNum(){
        Map<String, Integer> map = homeService.wranTypeNum();

        return R.ok().put("data",map);
    }

    @GetMapping("wranTopicNum")
    public R wranTopicNum(){
        List<Map<String, Object>> maps = homeService.topicByWarn();
        return R.ok().put("data",maps);

    }

}
