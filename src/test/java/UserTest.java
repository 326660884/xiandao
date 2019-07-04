import cn.cnic.xiandao.XianDaoMain;
import cn.cnic.xiandao.dao.PermissionRepository;
import cn.cnic.xiandao.module.SysPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XianDaoMain.class)
public class UserTest {


    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    public void testDao(){
        List<SysPermission> lists = permissionRepository.findPermissionByUserName("xu");
        for(SysPermission p:lists){
            System.out.println(p.toString());
        }
    }

}
