package cn.bdqn.entity;

import javax.persistence.*;

//@Entity:标明这个时实体类   @Table:声明这个实体类与哪个表有关系(建立与表之间的联系)
@Entity
@Table(name="cst_customer")
public class Customer {
    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    @Id //声明主键
        @Column(name="cust_id")//数据库字段与类的属性名称关联
        @GeneratedValue(strategy=GenerationType.IDENTITY) //配置主键的生成策略 可以不给
        private Long custId;

        @Column(name="cust_name") //指定和表中cust_name字段的映射关系
        private String custName;

        @Column(name="cust_source")//指定和表中cust_source字段的映射关系
        private String custSource;

        @Column(name="cust_industry")//指定和表中cust_industry字段的映射关系
        private String custIndustry;

        @Column(name="cust_level")//指定和表中cust_level字段的映射关系
        private String custLevel;

        @Column(name="cust_address")//指定和表中cust_address字段的映射关系
        private String custAddress;

        @Column(name="cust_phone")//指定和表中cust_phone字段的映射关系
        private String custPhone;


    public Long getCustId() {
            return custId;
        }
        public void setCustId(Long custId) {
            this.custId = custId;
        }
        public String getCustName() {
            return custName;
        }
        public void setCustName(String custName) {
            this.custName = custName;
        }
        public String getCustSource() {
            return custSource;
        }
        public void setCustSource(String custSource) {
            this.custSource = custSource;
        }
        public String getCustIndustry() {
            return custIndustry;
        }
        public void setCustIndustry(String custIndustry) {
            this.custIndustry = custIndustry;
        }
        public String getCustLevel() {
            return custLevel;
        }
        public void setCustLevel(String custLevel) {
            this.custLevel = custLevel;
        }
        public String getCustAddress() {
            return custAddress;
        }
        public void setCustAddress(String custAddress) {
            this.custAddress = custAddress;
        }
        public String getCustPhone() {
            return custPhone;
        }
        public void setCustPhone(String custPhone) {
            this.custPhone = custPhone;
        }


}
