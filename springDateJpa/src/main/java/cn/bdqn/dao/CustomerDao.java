package cn.bdqn.dao;

import cn.bdqn.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 使用需要继承JpaRepository<实体类，实体类的id类型>：代表基本的增删改查操作，里面封装的都是基本的一些方法
 * ,JpaSpecificationExecutor<实体类>：代表的是复杂的查询 比如：分页
 */
public interface CustomerDao extends JpaRepository<Customer,Long> , JpaSpecificationExecutor<Customer> {

    /**
     * 需求：查询全部客户
     * @Query:默认使用jpql语句进行查询
     * value:JPQL语法
     * @return
     */
    @Query(value = "from Customer ")
    public List<Customer> findByAllJpql();

    /**
     * 根据客户的名称惊喜准确查询
     * SQL：select * from cst_customer where customer_name = ?
     * JPQL：from Customer where custName = ?
     */
    @Query("from Customer where custName = ?")
    public Customer findByNameJpql(String name);

    /**
     * 根据客户名称模糊查询并且根据地址准确查询客户信息
     * SQL：select * from cst_customer where cust_name like ? and cust_address = ?
     * JPQL：from Customer where custName like ? and custAddress = ?
     */
    @Query("from Customer where custName like ? and custAddress = ?")
    public Customer findAllByNameAndAddressJpql(String name,String address);

    /**
     * 通过id修改客户   仅需了解
     * SQL:update cst_customer set cust_name = ? where cust_id = ?
     * JPQL:update Customer set custName = ? where custId = ?
     * 如果使用jpql语句经行修改必须添加：@Modifying
     */
    @Query("update Customer set custName = ? where custId = ?")
    @Modifying
    public int updateJpql(String name,Long id);

    /**
     * 根据客户名称模糊查询并且根据地址模糊查询客户信息
     * SQL：select * from cst_customer where cust_name like ? and cust_address like ?
     * nativeQuery: false(默认使用jpql语句查询) / true 使用sql语句查询
     */
    @Query(value = "select * from cst_customer where cust_name like ? and cust_address like ?",nativeQuery = true)//官方不推荐
    public Customer findAllByNameAndAddressSql(String name,String address);

    /**
     * 使用命名规范查询
     *  根据客户名称查询客户
     *  命名规范：findBy+类的属性名(首字母大写)
     */
    public Customer findByCustName(String name);

    /**
     * 根据客户名称模糊查询并且根据地址模糊查询客户信息
     */
    public Customer findByCustNameLikeAndCustAddressLike(String name,String address);
}

