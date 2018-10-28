import com.zdk.bean.Dept;
import com.zdk.bean.Employee;
import com.zdk.dao.DeptMapper;
import com.zdk.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 功能描述:
 * Created by zhaodengke on 2018/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 测试crud
     */
    @Test
    public void testCRUD() {
        /*Employee employee = new Employee();
        employee.setDeptId(1);
        employee.setEmail("91283098@qq.com");
        employee.setEmpId(1);
        employee.setEmpName("张三");
        this.employeeMapper.insert(employee);
        */

        /*Dept dept = new Dept();
        dept.setDeptId(1);
        dept.setDeptName("测试部门");
        this.deptMapper.insert(dept);*/

        EmployeeMapper employeeMapper = this.sqlSessionTemplate.getMapper(EmployeeMapper.class);
        DeptMapper deptMapper = this.sqlSessionTemplate.getMapper(DeptMapper.class);
        for (int i = 2; i < 10; i++) {
            Employee employee = new Employee(i, "zhangsan" + i, "m", "12312" + i + "@163.com", i);
            Dept dept = new Dept(i, "xx" + i + "部门");
            employeeMapper.insert(employee);
            deptMapper.insert(dept);
        }

        List<Employee> employees = this.employeeMapper.selectWithDept();
        System.out.println(employees);
    }

}
