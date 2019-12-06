import cn.cnic.xiandao.XianDaoMain;
import cn.cnic.xiandao.mapper.EmployeeMapper;
import cn.cnic.xiandao.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
<<<<<<< HEAD:xiandao-develop/src/test/java/MyJDBC.java
/**
=======

>>>>>>> f6d5910ea7277fb33786a5dd921932996f2d92a3:src/test/java/MyJDBC.java
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XianDaoMain.class)

public class MyJDBC {

    @Autowired
    private EmployeeMapper employeeMapper;
//    @Resource
//    BaseServiceImpl<EmployeeMapper,Employee> service;


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
//        List<Employee> list = service.list();
//        System.out.println("count:  "+service.count());
//        System.out.println("count:  "+list.size());


    }

}
**/