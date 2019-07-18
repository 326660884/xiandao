import cn.cnic.xiandao.XianDaoMain;
import cn.cnic.xiandao.mapper.EmployeeMapper;
import cn.cnic.xiandao.model.Employee;
import cn.cnic.xiandao.service.impl.BaseServiceImpl;
import cn.cnic.xiandao.utils.ApplicationUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XianDaoMain.class)
public class MyJDBC {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Resource
    BaseServiceImpl<EmployeeMapper,Employee> service;


    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setId(602L);
        employee.setName("ssss");
        int insert = employeeMapper.insert(employee);
        System.out.printf("resutl: "+insert);
    }

    @Test
    public void selectPapge(){
//        Page<Employee> employeePage = new Page<>(1,100);
//        QueryWrapper<Employee> queryWrapper = new QueryWrapper();
//
//        IPage<Employee> employeeIPage = employeeMapper.selectPage(employeePage, null);
//        for (Employee e: employeeIPage.getRecords()) {
//            System.out.println(e.toString());
//        }
        List<Employee> list = service.list();
        System.out.println("count:  "+service.count());
        System.out.println("count:  "+list.size());


    }

}
