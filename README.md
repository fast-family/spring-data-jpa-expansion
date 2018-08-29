



# Spring data jpa expansion

spring data jpa expansion 是一款针对spring data jpa 增强的插件,其功能主要对增删改查做二次封装,达到使用同一风格.

# 项目依赖

``` 
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <optional>true</optional>
</dependency>
```

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

# 使用示例



```java
package cn.com.spring.data.jpa.example.config;

import com.zs.spring.data.jpa.repository.BaseSimpleJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseSimpleJpaRepository.class,
        basePackages = "cn.com.spring.data.jpa.example.dao")
@EnableSpringDataWebSupport
public class SpringDataJpaConfig {
}
```

```java
package cn.com.spring.data.jpa.example.dao;

import cn.com.spring.data.jpa.example.entity.SysUser;
import com.zs.spring.data.jpa.repository.BaseJpaRepository;
import com.zs.spring.data.jpa.repository.BaseRepository;

public interface SysUserRepository extends BaseRepository<SysUser,String> {

}
```

```java
package cn.com.spring.data.jpa.example.entity;

import com.zs.spring.data.jpa.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity <String>{


    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Integer status;



}

```



```java
package cn.com.spring.data.jpa.example;

import cn.com.spring.data.jpa.example.dao.SysUserRepository;
import cn.com.spring.data.jpa.example.entity.SysUser;
import com.zs.spring.data.jpa.Criteria;
import com.zs.spring.data.jpa.Order;
import com.zs.spring.data.jpa.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaExampleApplicationTests {


	@Autowired
	private SysUserRepository sysUserRepository;

	@Test
	public void saveOrUpdateTest(){
		SysUser sysUser = new SysUser();
		sysUser.setPassword("123456");
		sysUser.setUserName("zhangsan");
		sysUser.setStatus(1);
		sysUserRepository.save(sysUser);
	}

	@Test
	public void deleteTest(){
		sysUserRepository.delete("id");
	}

	@Test
	public void findTest() {
		Criteria<SysUser> criteria = new Criteria<>();
		criteria.add(Restrictions.eq("status",1));//等于
		criteria.add(Restrictions.like("userName","zhangsan"));//模糊查询
		criteria.add(Restrictions.ne("password","123456"));//不等于
		criteria.addOrder(Order.asc("status"));//按状态排序
		sysUserRepository.findAll(criteria);
	}

}

```

qq群号:849555205
