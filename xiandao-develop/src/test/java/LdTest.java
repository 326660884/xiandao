import cn.cnic.xiandao.XianDaoMain;
import cn.cnic.xiandao.mapper.ExhibitSinoEventMapper;
import cn.cnic.xiandao.model.ExhibitSinoEvent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XianDaoMain.class)
public class LdTest {


    @Test
    public void getSinoEvent() throws IOException {

    }

    @Test
    public void  sd() {
        int time = 1;
        while (true) {
            if ((20) % (12 + time) == 0) {
                System.out.println((12 + time) + " " + (32 + time));
                continue;
            }
            time++;
        }
    }



    }



