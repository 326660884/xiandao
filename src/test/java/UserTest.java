import cn.cnic.xiandao.XianDaoMain;
import cn.cnic.xiandao.dao.UserDao;
import cn.cnic.xiandao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XianDaoMain.class)
@Slf4j
public class UserTest {

    @Autowired
    UserService userService;


    @Test
    public void testAdd(){
        int add = userService.add("zhangsan", "abc");
        log.debug("add = {}",1);
        int add1 = userService.add("admin", "abc");
        log.debug("add1 = {}",add1);
    }

}
