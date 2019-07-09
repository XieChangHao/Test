package cn.bdqn;

import cn.bdqn.dao.CustomerDao;
import cn.bdqn.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明这个类是spring的测试类
//加载配置文件
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    //注入dao
    @Autowired
    private CustomerDao customerDao;

    /**
     * 需求：查询全部客户
     */
    @Test
    public void testFindByNameJpql(){
        List<Customer> list = customerDao.findByAllJpql();
        for (Customer customer : list) {
            System.err.println(customer.getCustName());
        }
    }

    /**
     * 根据客户的名称惊喜准确查询
     */
    @Test
    public void findByNameJpql(){
        Customer customer = customerDao.findByNameJpql("北小青鸟");
        System.err.println(customer.getCustName());
    }

    /**
     * 根据客户名称模糊查询并且根据地址准确查询客户信息
     */
    @Test
    public void findAllByNameAndAddressJpql(){
        Customer customer = customerDao.findAllByNameAndAddressJpql("%青鸟%", "广州");
        System.err.println(customer.getCustName() + "    " +  customer.getCustAddress());
    }

    /**
     * 通过id修改客户
     */
    @Test
    @Transactional  //增删改需要加事务：@Transactional
    @Commit //增删改需要提交:@Commit
    public void updateJpql(){
        int i = customerDao.updateJpql("青鸟", 9L);
        System.err.println(i);
    }

    /**
     * 根据客户名称模糊查询并且根据地址模糊查询客户信息
     */
    @Test
    public void findAllByNameAndAddressSql(){
        Customer customer = customerDao.findAllByNameAndAddressSql("%青鸟%", "%州%");
        System.err.println(customer.getCustName() + "    " +  customer.getCustAddress());
    }




}
