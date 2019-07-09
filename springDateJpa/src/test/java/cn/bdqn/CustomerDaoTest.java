package cn.bdqn;

import cn.bdqn.dao.CustomerDao;
import cn.bdqn.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明这个类是spring的测试类
//加载配置文件
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    //注入dao
    @Autowired
    private CustomerDao customerDao;


    //保存客户数据到数据库
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("测试");
        customerDao.save(customer);
    }

    /**
     * 修改id为19的客户信息
     * save():同时可以更新或者是插入
     * 如果传入的对象没有id值，那就执行插入的方法
     * 如果传入的对象有id值，那就执行更新的方法
     */
    @Test
    public void testSave2(){
        //获取id为9的客户数据
        Customer customer = customerDao.findOne(19L);
        customer.setCustName("修改数据测试");
        //save() 执行更新之前会查询数据库，如果查询的数据和更新的数据一样就不执行更新操作
        customerDao.save(customer);
    }

    //根据id删除数据
    @Test
    public void delete(){
        customerDao.delete(19L);
    }

    //根号id查询数据
    @Test
    public void findOne(){
        Customer customer = customerDao.findOne(9L);
        System.err.println(customer.getCustName());
    }

    //查询全部数据
    @Test
    public void findAll(){
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.err.println(customer.getCustName());
        }
    }

    //使用spring-date-jpa实现延迟加载
    //需求：使用延迟加载技术实现通过id查询客户数据
    @Test
    @Transactional  //@Transactional:防止延时加载的时候报错，没有该注解延时加载会报错
    public void getById(){
        //getOne():通过使用延迟加载的方式，通过id查询数据库
        Customer customer = customerDao.getOne(9L);
        System.err.println("------------------------------------------------------");
        System.err.println(customer.getCustName());
    }

    /**
     * 根据名字查询客户信息
     */
    @Test
    public void findByCustName(){
        Customer customer = customerDao.findByCustName("青鸟");
        System.err.println(customer.getCustName());
    }

    /**
     * 根据客户名称模糊查询并且根据地址模糊查询客户信息
     */
    @Test
    public void findByCustNameLikeAndCustAddressLike(){
        Customer customer = customerDao.findByCustNameLikeAndCustAddressLike("%青鸟%", "%州%");
        System.err.println(customer.getCustName() + "    " +  customer.getCustAddress());
    }

}
