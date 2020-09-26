

# Spring核心笔记



# 一、Spring核心 --- IOC

## 1. 核心概念

![](images\IOC_核心容器.png)

![](images\图片2.png)

**核心：**

​	主动获取变为被动接受



## 2. 解决程序耦合问题

### 2.1 程序的耦合

**（1）定义：**程序间的依赖关系

包括：**类之间的依赖**、**方法之间的依赖**

**（2）解耦：**`降低`程序间的依赖关系

**（3）解耦思路：**

​		第一步：使用反射来创建对象，二避免使用 `new`关键字

​		第二步：通过读取配置文件夹来获取创建对象全限定类名

**（4）开发思路：**应该做到编译器不依赖，运行时才依赖

## 3. IOC --- 控制反转

### (1) 相关依赖(pom.xml)：

```xml
	<dependencies>
		<dependency>
        	<groudId>org.springframework</groudId>
            <artifactId>spring-context</artifactId>
            <version>5.0.2.RELEASE</version>
        </dependency>
	</dependencies>
```

### (2) bean.xml配置配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="acctountService" class="com.itheima.service.impl.AccountServiceImpl">  
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions go here -->

</beans>
```

### (3） ApplicationContext的使用

```java
	public void beanFactoryTest(){
        ApplicationContet ac = new ClassPathXmlApplicationCOntext("bean.xml");
        //IAccountService as = (IAcctountService)ac.getBean("acctountService") ;
        //IAccountService as = ac.getBean(AccountService.class) ;
        IAccountService as = ac.getBean("acctountService",AccountService.class) ;
        
    }
```

### (4) ApplicationContext常用实现类说明：

1. ClassPathXmlApplicationContext: 

    它可以加载类路径下的配置文件，要求配置文件必须在类路路径下

2. FileSystemXmlApplicationContext: 

    它可以加载磁盘下任意路径下的配置文件(必须有访问权限)

3. AnnotationConfigApplicationContext: 

    自动注解

### (5) `ApplicationContext`和`BeanFactory`的区别

`ApplicationContext` --- 单例对象适用

​		它在构建核心容器是，创建对象采用的策略是**立即加载的方式**，即只要读取完配置文件马上就创建配置文件中的配置对象。

`BeanFactory` --- 多例对象使用（用的少）

​		它在构建核心容器时，创建对象采取的策略是**延迟加载的方式**，也就是，什么时候根据id获取对象了，什么时候真正的创建对象。

`BeanFactory`使用案例

```java
public void beanFactoryTest(){
    Resource resource = new ClassPathResource("bean.xml");
    BeanFactory factory = new XmlBeanFactory(resource);
    IAccountService as = factory.getBean("iAccountService",AccountServiceImpl.class);
}
```



### (6) 创建Bean的三种方式（重点）

#### 1. 构造函数(默认无参构造)

```java
public class AccountDaoImpl implement AccountDao{
    public AccountDaoImpl(){
        
    }
    public AccountDaoImpl(String name){
        this.name = name ;
    }
    ...
}
```

bean.xml文件配置：

```xml
<bean id="accountDao" class= "com.zzt.dao.AccountDaoImpl">
	<constructor-arg name="name" value="张三"/>
</bean>
```



#### 2. 工厂创建对象：

```java
public class BeanFactory {
    public AccountDao getAccountDao(){
        return new AccountDaoImpl() ;
    }
}
```

```xml
<bean id="beanFactory" class="com.zzt.factory.BeanFactory"/>
<bean id="accountDao" factory-bean="beanFactory" factory-method="getAccountDao"/>
```



#### 3. 静态方法创建对象

```java
public class BeanFactory {
    public static AccountDao getAccountDao(){
        return new AccountDaoImpl() ;
    }
}
```



```xml
<bean id="accountDao" class="com.zzt.factory.BeanFactory" factory-method="getAccountDao"/>
```



### (7) Bean的作用范围调整 --- 属性 scope

|      属性值      |                             作用                             |
| :--------------: | :----------------------------------------------------------: |
|   `singleton`    |                       单例（ 默认值）                        |
|   `prototype`    |                             多例                             |
|    `request`     |                   作用于web应用的请求范围                    |
|    `session`     |                   作用于web应用的会话防卫                    |
| `global-session` | 作用于集群环境下的绘画范围（全局会话范围），当不是集群环境是，它就是`session` |

（8）Bean的生命周期：



## 4. Spring IOC依赖注入

### (1) 依赖注入 --- Dependency Injection

- `IOC`的作用：降低程序见的耦合（依赖关系）
- 依赖关系的管理： 以后交给`Spring`来维护，在当前类需要用到其他类的对象，有Spring为我们提供，我们只需要在配置文件中说明依赖关系的维护 --- 依赖注入

**注入的数据类型(三大类)**

- 基本数据类型和String
- 其他`Bean`类型（在配置文件或注解配置的bean）
- 复杂类型/集合类型

**注入的方式（三种）**

- 使用构造函数提供
- 使用set方法提供
- 使用注解提供

### （2）注入方式

#### 1. 构造函数注入

**使用的标签：**`constructor-arg`

```xml
<bean id="accountDao" class= "com.zzt.dao.AccountDaoImpl">
	<constructor-arg name="name" value="张三"/>
</bean>
```

（注意：不能解决复杂数据类型，如Date类型）

解决方案：

![](images\wps12.jpg)

Value和ref的区别：

- `value`：用于提供基本类型和String类型的数据
- `ref`：用于指定其他bean类型数据

优缺点：

> 优点：在获取bean对象时，注入数据时必须的操作，否则无法成功创建对象
>
> 缺点：改变了bean对象的实例化方式，使我们在创建对象时，必须要提供特定的数据



#### 2. setXXX方法注入：（更加常用）

使用的标签：property

案例：

```xml
<bean id="accountService" class= "com.zzt.dao.AccountServiceImpl">
	<property name="name" value = "张三" />
    <property name="accountDao" ref = "accountDao" />
</bean>
```

优缺点：

> 优点：创建对象时，没有明确的限制，可以直接使用默认构造函数
>
> 缺点：如果有某个成员变量必须有值，则获取对象时可能set方法没有执行 



## 5. 基于注解的IOC配置

### (1) 定义：



### (2) 重要标签：

1. @Component相关注解：

| @Componen衍生注解 |      作用      |
| :---------------: | :------------: |
|     @Service      | 一般用于表现层 |
|    @Controller    | 一般用于业务层 |
|    @Repository    | 一般用在持久层 |

2. @Autowired

| @Autowired衍生注解 |                             作用                             |
| :----------------: | :----------------------------------------------------------: |
|     @Qualifier     | 在按照类型注入的基础上再按照名称注入。它再给类成员注入时(不能单独使用)。但是再给方法参数注入时可以 |
|     @Resource      |            直接按照`bean`的`id`注入(可以单独使用)            |
|       @Value       |               注解基本类型和String的类型的数据               |

3. @Scope

4. @PostConstruct 和 @PreDestroy (生命周期相关了解：)

5. @ComponentScan 和 @Configuration (新注解，用于扫描包)

### (3) @Component

**作用：**用于吧当前类对象存入Spring IOC 容器中

属性：

- value： 用于指定`bean`的`id`。默认值 = 当前类型(首字母小写)

使用步骤：

```java
@Compoment
public class AccountServiceImpl{
    ...
}
```

beans.xml文件的配置

```xml
<context:component-scan base-package="..."/>
```



**@Component衍生的注解**

> @Controller：一般用于表现层
>
> @Service：一般用于业务层
>
> @Repository：一般用在持久层

### (4) @Autowired

自动按照类型注入数据

**定义：**

​		他们的作用就和在小毛驴配置文件中的`bean`标签中写一个`<property>`标签的作用一样

| @Autowired衍生注解 |                             属性                             |                             作用                             |
| :----------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|     @Qualifier     |                 value：用户指定注入bean的id                  | 在按照类型注入的基础上再按照名称注入。它再给类成员注入时(不能单独使用)。但是再给方法参数注入时可以 |
|     @Resource      |                   name: 用户指定`bean`的id                   |            直接按照`bean`的`id`注入(可以单独使用)            |
|       @Value       | value：用于指定数据的值，它可以使用Spring中的SpEl表达式(${表达式}) |               注解基本类型和String的类型的数据               |

**推荐使用：**`@Autowired`最好与`@Qualifier()`一起使用

**作用：**

​		自动按照类型注入。只要容器有唯一的一个`bean`对象类型和要主人椅的变量类型匹配，就可以注入成功。

**出现的位置：**

> - 变量上
> - 方法上

**细节：**

- 在使用注解注入时，set方法就不是必须的了。



### (5) @Scope(“ ”)

用于改变作用范围的

取值范围：

>单例：singleton（默认）
>
>多例：prototype



### (6) 生命周期相关注解

- `PreDestroy`：用于指定销毁方法
- `PostConstruct`:用于指定初始化方法

**注意：**多例对象，Spring不能销毁



## 6. 新注解

|          新注解          |                      作用                      |
| :----------------------: | :--------------------------------------------: |
|      @Configuration      |    指定当前类是一个配置类(相当于@Component)    |
|      @ComponentScan      | 用于通过注解指定Spring在创建容器时需要扫描的包 |
|          @Bean           |                                                |
|         @Import          |                                                |
| @Import、@PropertySource |                                                |

**相关使用类：**`AnnotationConfigApplicationContext`

### (1) @Configuration 和 @ComponentScan

**@Configuration**

​	作用：指定当前类是一个配置类

**@ComponentScan**

​	作用：用于通过注解指定Spring在创建容器时需要扫描的包

​	属性：

- value：它和basePackages的作用是一样的，都是用于指定创建容器时需要扫描的包

**等同于：**

```xml
<context:component-scan base-packages="..."/>
```

### (2) @Bean

**重点：**一般和`@Configuration`一起使用

**作用：**用于把当前方法的返回值作为bean对象存入Spring的ioc容器中

**属性：**

- name：用于指定bean的id。默认值 = 当前方法的名称

**细节：**

​		当我们使用注解配置方式时，如果方法有参数，Spring框架会去容器查找有没有可用的bean对象，查找的方式和`@Autowired`注解的作用一样的。

```java
//当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写（本次案例，可以不写）
@Configuration
public void SpringConfiguration{
    @Bean("dataSource")
    public DataSource createDataSource(){
        return new DataSource() ;
    }
}
// ---
@Test
void test(){
    Appcalication ac = new AnnotationConfigApplicationCOntext(SpringConfiguration.class);
    DataSource dataSource = ac.getBean("dataSource",DataSource.class) ;
}
```

### (3) @Import

**作用：**导入其他的配置类

**属性：**

- value：用于指定其他配置类的字节码

​		当我们使用 `@Import` 的注解之后，有 `@Import` 注解的类就是父配置类，而导入的都是自配置类

**案例：**

```java
// 子配置类
public class JdbcConfig {
    // ...
}
// ------- 
// 主配置类
@Configuration
@Import(JdbcConfig.class)
public void SpringConfiguration{
    @Bean("dataSource")
    public DataSource createDataSource(){
        return new DataSource() ;
    }
}

```

### (4) @PropertySource

**作用：**

​		用于指定properties文件的文职

**属性：**

- value：指定文件的名称和路径

**关键字：**classpath 

**案例：**

1. jdbcConfig.properties配置文件

```properties
jdbc.driver=com.mysql.jdbc.Drvier
jdbc.url=jdbc:mysql://localhost:3306/db_spring
jdbc.username=root
jdbc.password=123456
```

2. 在配置类中使用`jdbcConfig.properties`配置文件

```java
//子配置类
public class JdbcConfig {
    @Value("${jdbc.Driver}")
    private String driver ;
    //...
}

// ------- 
//主配置类
@Configuration
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public void SpringConfiguration{
    @Bean("dataSource")
    public DataSource createDataSource(){
        return new DataSource() ;
    }
}

// ------ 
//测试类
void test(){
    Appcalication ac = new AnnotationConfigApplicationCOntext(SpringConfiguration.class) ;
    DataSource dataSource = ac.getBean("dataSource",DataSource.class) ;
}
```



# 二、AOP --- 动态代理

参考官网：[https://www.jianshu.com/p/82d58edceddb](https://www.jianshu.com/p/82d58edceddb)

## 1. 概述

**AOP：**（Aspect Oriented Programming ） 面向切面编程

依赖文件：

```xml
<dependency>
	<groupId>org.aspecj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.7</version>
</dependency>
```



## 2. 动态代理

**特定：**字节码随用随创建，随用随加载

**作用**：不修改源代码的基础上方法加强

**分类：**

- 基于接口的动态代理

- 基于子类的动态代理

### (1) 基于接口的动态代理

**涉及的类：**`Proxy`（提供者：JDK官方）

**如何创建代理对象：**

​		使用`Proxy`类中的`newProxyInstance`方法

**创建代理对象的要求：**

​		被代理类最少实现一个接口，如果没有则不能使用

|      `newProxyInstance`方法的参数      |                             作用                             |
| :------------------------------------: | :----------------------------------------------------------: |
|         Classloader(类加载器)          | 它是作用于加载代理对象的字节码的，和被代理对象使用相同的类加载器。**固定写法** |
|          Class[] (字节码数组)          |    它是用于让代理对象和被代理对象有相同方法。**固定写法**    |
| InvocationHandler (用于提供增强的代码) | 它是让我们如何代理。我们一般都是些该接口的实现类，通常情况下都是匿名内部类，但不是必须的。此接口的实现类都是谁写的。 |

案例：

| invoke方法的参数 |             含义             |
| :--------------: | :--------------------------: |
|   Object proxy   |        代理对象的应用        |
|  Method method   |        当前执行的方法        |
|  Object[] args   |    当前执行方法所需的参数    |
|  Return Object   | 和被代理对象方法相同的返回值 |



```java
//一个生产者
public class Producer implements IProducer {
    //销售
    public void saleProduct(float money){
        System.out.println("销售产品："+money);
    }
    //售后
    public void afterService(float money){
        System.out.println("提供售后服务，得到的前"+money);
    }
} 
//-----
//消费者
public class Client {
    public static void main(String[] args){
        Producer producer = new Producer() ;
        IProduct proxyProducer = (IProduct)Proxy.newProxyInstance(producer.getClass.getClassLoader,producer.getClass.getInserfaces,new InvocationHandler(){
            /**
             * 作用，执行被代理对象和任何接口方法都会经过该方法
             */
            public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
                //提供增强代码的
                Object returnValue = null ;
                //1. 获取方法执行的参数
                Float money = (Float)args[0] ;
                //2. 判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    System.out.println("方法执行前的操作：");
                    returnValue = method.invoke(producer,money*0.8f);
                    System.out.println("方法执行后的操作：");
                }
                return returnValue ;
            }
        });
        proxyProducer.saleProduct(10000f);
    }
}
```



### (2) 基于子类的动态代理

**涉及的类：**`Enhancer`(提供者第三方 `cglib`库)

**如何创建代理对象：**

​		使用`ENhancer`类中的`create`方法

**创建代理对象的要求：**

​		被代理类不能是最终类

|      `create`方法的参数      |                             说明                             |
| :--------------------------: | :----------------------------------------------------------: |
|        Class(字节码)         |                  它用于执行代理对象的字节码                  |
| Callback(用于提供增强的代码) | 它是让我们写如何代理，我们一般都是些接口的实现类，通常情况下都是匿名内部类，但不是必须的。一般写的都是该接口的子接口实现类：MethodInsterceptor |

**案例：**

导入依赖：

```xml
<dependency>
	<groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.1_3</version>
</dependency>
```



```java
//一个生产者
public class Producer implements IProducer {
    //销售
    public void saleProduct(float money){
        System.out.println("销售产品："+money);
    }
    //售后
    public void afterService(float money){
        System.out.println("提供售后服务，得到的前"+money);
    }
}
//------
//消费者
public class Client {
    public static void main(String[] args){
    	final ProducerImpl producer = new ProducerImpl() ;
        IProducer cglibProducer = (IProducer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;
                //1. 获取方法执行的参数
                Float money = (Float)objects[0] ;
                //判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f) ;
                }
                return returnValue ;
            }
        });
        cglibProducer.saleProduct(10000f);
    }
}
```



## 3. AOP --- 动态代理

**专业术语：**

- `Aspect`（切面）： `Aspect` 声明类似于 Java 中的类声明，在 Aspect 中会包含着一些 Pointcut 以及相应的 Advice。
- `Joint point`（连接点）：表示在程序中明确定义的点，典型的包括方法调用，对类成员的访问以及异常处理程序块的执行等等，它自身还可以嵌套其它 `joint point`。
- `Pointcut`（切入点）：表示一组 `joint point`，这些 `joint point` 或是通过逻辑关系组合起来，或是通过通配、正则表达式等方式集中起来，它定义了相应的 `Advice` 将要发生的地方。
- `Advice`（增强）：`Advice` 定义了在 `Pointcut` 里面定义的程序点具体要做的操作，它通过 `before`、`after` 和 `around` 来区别是在每个 joint point 之前、之后还是代替执行的代码。
- `Target`（目标对象）：织入 Advice 的目标对象.。
- `Weaving`（织入）：将 `Aspect` 和其他对象连接起来, 并创建 `Adviced object` 的过程

**Advice 的类型**

- 前置通知(`before advice`), 在 join point 前被执行的 advice. 虽然 before advice 是在 join point 前被执行, 但是它并不能够阻止 join point 的执行, 除非发生了异常(即我们在 before advice 代码中, 不能人为地决定是否继续执行 join point 中的代码)after return advice, 在一个 join point 正常返回后执行的 advice
- 返回后通知(`after throwing advice`), 当一个 join point 抛出异常后执行的 advice
- 抛出异常后通知(`after(final) advice`), 无论一个 join point 是正常退出还是发生了异常, 都会被执行的 advice.
- 环绕通知(`around advice`), 在 join point 前和 joint point 退出后都执行的 advice. 这个是最常用的 advice.
- `introduction`，introduction可以为原有的对象增加新的属性和方法。



## 4. AOP的使用案例

### (1) 导入依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>5.0.2.RELEASE</version>
</dependency>
<!--
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.7</version>
</dependency>
-->
```

### (2) 引入Spring的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!-- ... -->
    
</beans>
```

### (3) 步骤三: 编写目标类

```java
public interface IProducer {
    //销售
    void saleProduct(float money);
    //售后
    void afterService(float money);

}
// ---- 实现类
public class ProducerImpl implements IProducer {
    //销售
    @Override
    public void saleProduct(float money){
        System.out.println("销售产品："+money);
    }
    //售后
    @Override
    public void afterService(float money){
        System.out.println("提供售后服务，得到的前"+money);
    }
}

```

```xml
	<!-- 配置Spring的IOC -->
    <bean id="producer" class="com.zzt.producer.impl.ProducerImpl"/>
```

### (4) 表写切面类

```java
public class Logger {
    public void printLog(){
        System.out.println("Logger类中的printLog方法执行!!!");
    }
}
```

### (5)配置增强

```xml
<!-- 配置切面类 Logger -->
<bean id="logger" class="com.zzt.producer.log.Logger"/>
<!-- 进行 aop 的配置 -->
<aop:config>
    <!-- 配置切入点 -->
    <aop:pointcut id="before" expression="execution( * com.zzt.producer.*.*(..))"/>
    <!-- 配置切面 -->
    <aop:aspect id="logAdvice" ref="logger">
        <!-- 配置前置通知 -->
        <aop:before method="printLog" pointcut-ref="before"/>
        <!--<aop:before method="printLog" pointcut="execution( * com.zzt.producer.*.*(..))"/>-->
    </aop:aspect>
</aop:config>
```

## 5. 切入点表达式

### (1) 标准表达式写法：

```javascript
[方法访问修饰符] 方法返回值 包名.类名.方法名(方法的参数)
```

1. 全通配写法：

```javascript
* *..*.*(..)
```

2. 访问修饰符可以省略

```javascript
void com.zzt.producer.impl.AccountServiceImpl.saveAccount(..)
```

3. 返回值可以使用通配符，表示任意返回值类型

```javascript
	* com.zzt.producer.impl.AccountServiceImpl.saveAccount(..)
```

4. 包名可以使用通配符，表示任意包。但是有多级包，就需要写几个*****：

```javascript
* *.*.*.*.AccountServiceImpl.saveAccount(..)
```

5. 包名可以使用`..`表示当前包及其子包

```javascript
* *..AccountServiceImpl.saveAccount(..)
```

6. 参数列表

![](images\wps1.jpg)



```text
execution(表达式)
表达式:
[方法访问修饰符] 方法返回值 包名.类名.方法名(方法的参数)
public * cn.itcast.spring.dao.*.*(..)	
       * cn.itcast.spring.dao.*.*(..)	//最常用的写法
       * cn.itcast.spring.dao.UserDao+.*(..)
       * cn.itcast.spring.dao..*.*(..)
```



## 6. 五种常用通知类型

参考网址：[https://www.cnblogs.com/chuijingjing/p/9806651.html](https://www.cnblogs.com/chuijingjing/p/9806651.html)

前置通知、后置通知、异常通知、最终通知、环绕通知

### (1) 前置通知

> 在目标方法执行之前执行执行的通知。

```xml
<aop:pointcut id="beforeMethod" expression="execution( * com.zzt.producer.*.*(..))"/>
<aop:before method="before" pointcut-ref="beforeMethod"/>
<!--<aop:before method="printLog" pointcut="execution( * com.zzt.producer.*.*(..))"/>-->
```

![](images\Spring_AOP_前置通知_joinPoint.png)

### (2) 环绕通知

> 在目标方法执行之前和之后都可以执行额外代码的通知。

![](images\Spring_AOP_环绕通知.png)



### (3) 后置通知

> 在目标方法执行之后执行的通知。

```xml
<!-- 后置通知 -->
<aop:after-returning method="afterReturn" pointcut-ref="pc1"/>
```

### (4) 异常通知

> 在目标方法抛出异常时执行的通知

```xml
<!-- 异常通知 -->
<aop:after-throwing method="afterThrow" pointcut-ref="pc1" throwing="e"/>
```

### (5) 最终通知

> 是在目标方法执行之后执行的通知。

​		和后置通知不同之处在于，后置通知是在方法正常返回后执行的通知，如果方法没有正常返-例如抛出异常，则后置通知不会执行。

​		而最终通知无论如何都会在目标方法调用过后执行，即使目标方法没有正常的执行完成。

​		另外，后置通知可以通过配置得到返回值，而最终通知无法得到。

​		最终通知也可以额外接收一个JoinPoint参数，来获取目标对象和目标方法相关信息，但一定要保证必须是第一个参数。

```xml
<!-- 最终通知 -->
<aop:after method="after" pointcut-ref="pc1" />
```

### (6) 物种通知的执行顺序

1. **在目标方法没有抛出异常的情况下**

- 前置通知

- 环绕通知的调用目标方法之前的代码

- 目标方法

- 环绕通知的调用目标方法之后的代码

- 后置通知

- 最终通知

2. **在目标方法抛出异常的情况下**

- 前置通知
- 环绕通知的调用目标方法之前的代码
- 目标方法 抛出异常 异常通知
- 最终通知

### (7) 五种通知类型应用场景

| **环绕通知** |          **控制事务 权限控制**           |
| :----------: | :--------------------------------------: |
| **后置通知** |      **记录日志(方法已经成功调用)**      |
| **异常通知** |          **异常处理 控制事务**           |
| **最终通知** | **记录日志(方法已经调用，但不一定成功)** |



## 7. AOP注解版

**案例：**

```java
package com.aaa.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@Aspect
public class LogAdvice {
    @AfterReturning("execution(void *User(..))")
    public void log(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"执行之后记录成功");
    }
    @Before("execution(void *User(..))")
    public void befor(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"执行之前记录成功");
    }
    @Around("execution(void *User(..))")
    public  void around(ProceedingJoinPoint pjp){
        String name=pjp.getSignature().getName();
        System.out.println(name+"环绕执行前");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(name+"环绕后执行");
    }
    @After("execution(void *User(..))")
    public  void after(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"最终执行记录成功");
    }
    @AfterThrowing(pointcut = "execution(void *User(..))")
    public  void excaption(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println("执行"+name+"时发生异常");
    }
}
```

bean.xml配置文件

```xml
<!-- 开启Spring对注解AOP的支持 -->
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```



# 三、Spring事务管理

参考网址：[https://www.cnblogs.com/liantdev/p/10149443.html](https://www.cnblogs.com/liantdev/p/10149443.html)

## 1. 事务

### (1) 事务的概念

​		我们知道，在JavaEE的开发过程中，service方法用于处理主要的业务逻辑，而业务逻辑的处理往往伴随着对数据库的多个操作。

​		以我们生活中常见的转账为例，service方法要实现将A账户转账到B账户的功能，则该方法内必定要有两个操作：先将A账户的金额减去要转账的数目，然后将B账户加上相应的金额数目。这两个操作必定要全部成功，方才表示本次转账成功；若有任何一方失败，则另一方必须回滚（即全部失败）。事务指的就是这样一组操作：这组操作是不可分割的，要么全部成功，要么全部失败

### (2) 事务的特性

事务具有ACID四个特性：

1. **原子性(Atomicity)**：事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
2. **一致性(Consistency)**：事务在完成后数据的完整性必须保持一致
3. **隔离性(Isolation)**：多个用户并发访问数据库时，一个用户的事务不能被其他用户的事务所干扰，多个并发事务之间的数据要相互隔离
4. **持久性（Durability）**：一个事务一旦被提交，它对数据库中数据的改变应该是永久性的，即使数据库发生故障也不应该对其有任何影响



## 2. Spring 事务管理接口

​		Spring 事务管理为我们提供了三个高层抽象的接口，分别是`TransactionProxyFactoryBean`，`TransactionDefinition`，`TransactionStatus`

### (1) PlatformTransactionManager事务管理器

​		Spring事务管理器的接口是org.springframework.transaction.PlatformTransactionManager，Spring框架并不直接管理事务，而是通过这个接口为不同的持久层框架提供了不同的PlatformTransactionManager接口实现类，也就是将事务管理的职责委托给Hibernate或者iBatis等持久化框架的事务来实现

`PlatformTransactionManager`接口**源码**：

```java
public interface PlatformTransactionManager {
    //事务管理器通过TransactionDefinition，获得“事务状态”，从而管理事务
    TransactionStatus getTransaction(@Nullable TransactionDefinition var1) throws TransactionException;
    //根据状态提交
    void commit(TransactionStatus var1) throws TransactionException;
   //根据状态回滚
    void rollback(TransactionStatus var1) throws TransactionException;
}
```

### (2) TransactionDefinition定义事务基本属性

org.springframework.transaction.TransactionDefinition接口用于定义一个事务，它定义了Spring事务管理的五大属性：**隔离级别**、**传播行为**、**是否只读**、**事务超时**、**回滚规则**

1. **隔离级别**

什么是事务的隔离级别？我们知道，隔离性是事务的四大特性之一，表示多个并发事务之间的数据要相互隔离，隔离级别就是用来描述并发事务之间隔离程度的大小

在并发事务之间如果不考虑隔离性，会引发如下安全性问题：

- **脏读** ：一个事务读到了另一个事务的未提交的数据
- **不可重复读** ：一个事务读到了另一个事务已经提交的 update 的数据导致多次查询结果不一致
- **幻读** ：一个事务读到了另一个事务已经提交的 insert 的数据导致多次查询结果不一致

在 Spring 事务管理中，为我们定义了如下的隔离级别：

- **ISOLATION_DEFAULT**：使用数据库默认的隔离级别
- **ISOLATION_READ_UNCOMMITTED**：最低的隔离级别，允许读取已改变而没有提交的数据，可能会导致脏读、幻读或不可重复读
- **ISOLATION_READ_COMMITTED**：允许读取事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
- **ISOLATION_REPEATABLE_READ**：对同一字段的多次读取结果都是一致的，除非数据事务本身改变，可以阻止脏读和不可重复读，但幻读仍有可能发生
- **ISOLATION_SERIALIZABLE**：最高的隔离级别，完全服从**ACID的隔离级别**，确保不发生脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的

2. **传播行为**

​		Spring事务传播机制规定了事务方法和事务方法发生嵌套调用时事务如何进行传播，即协调已经有事务标识的方法之间的发生调用时的事务上下文的规则：

​		Spring定义了七种传播行为，这里以方法A和方法B发生嵌套调用时如何传播事务为例说明：

- **PROPAGATION_REQUIRED**：A如果有事务，B将使用该事务；如果A没有事务，B将创建一个新的事务
- **PROPAGATION_SUPPORTS**：A如果有事务，B将使用该事务；如果A没有事务，B将以非事务执行
- **PROPAGATION_MANDATORY**：A如果有事务，B将使用该事务；如果A没有事务，B将抛异常
- **PROPAGATION_REQUIRES_NEW**：A如果有事务，将A的事务挂起，B创建一个新的事务；如果A没有事务，B创建一个新的事务
- **PROPAGATION_NOT_SUPPORTED**：A如果有事务，将A的事务挂起，B将以非事务执行；如果A没有事务，B将以非事务执行
- **PROPAGATION_NEVER**：A如果有事务，B将抛异常；A如果没有事务，B将以非事务执行
- **PROPAGATION_NESTED**：A和B底层采用保存点机制，形成嵌套事务

### (3) TransactionStatus事务状态

​		org.springframework.transaction.TransactionStatus接口用来记录事务的状态，该接口定义了一组方法，用来获取或判断事务的相应状态信息。
TransactionStatus接口源码：

```java
public interface TransactionStatus extends SavepointManager, Flushable {
    boolean isNewTransaction();// 是否是新的事物

    boolean hasSavepoint();// 是否有恢复点

    void setRollbackOnly();// 设置为只回滚

    boolean isRollbackOnly();// 是否为只回滚

    void flush();// 刷新

    boolean isCompleted();// 是否已完成
}
```



## 3. Spring 事务管理实现方式

​		Spring 事务管理有两种方式：**编程式事务管理**、**声明式事务管理**
编程式事务管理通过TransactionTemplate手动管理事务，在实际应用中很少使用，我们来重点学习声明式事务管理
​		声明式事务管理有三种实现方式：**基于TransactionTemplate的方式**、**基于AspectJ的XML方式**、**基于注解的方式**

### (1) **基于TransactionTemplate的方式**

```java
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate ;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void payMoney(String name, Long amount) {
        String sql = "update account set money= money - ?  where name = ? " ;
        int update = jdbcTemplate.update(sql,amount,name);
        if (update>=1){
            System.out.println("支出成功！！！");
        }
    }

    @Override
    public void collectMoney(String name, Long amount) {
        String sql = "update account set money=money + ?  where name = ? " ;
        int update = jdbcTemplate.update(sql, amount, name);
        if (update>=1){
            System.out.println("收款成功！！！");
        }
    }
}
// ------
//业务层
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao ;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionTemplate transactionTemplate ;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    /**
     * 转账业务
     * @param payer 付款人
     * @param inner 收款人
     * @param money 交易金额
     */
    @Override
    public void transfer(final String payer, final String inner, final long money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.collectMoney(inner,money);
                accountDao.payMoney(payer,money);
            }
        }) ;
    }
}
```

beans.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd" >
    <!-- 业务层 IOC的配置 -->
    <bean id="accountService" class="com.zzt.service.impl.AccountServiceImpl">
        <property name="accountDao" ref="accountDao"/>
        <property name="transactionTemplate" ref="transactionTemplate"/>
    </bean> 
    <!-- 基于 TransactionTemplate 的事务管理 -->
    <!-- 创建模板 -->
    <bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
       <property name="transactionManager" ref="txManager"/>
    </bean>
    <!-- 配置事务管理器 ,管理器需要事务，事务从Connection获得，连接从连接池DataSource获得 -->
    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- 持久层的IOC配置 -->
    <bean id="accountDao" class="com.zzt.dao.impl.AccountDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>
    <!-- 数据源配置信息 -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/spring"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
</beans>
```



### (2) 基于AOP的XML方式

业务层代码修改为：

```java
public void transfer(final String payer, final String inner, final long money) {
        /*transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.collectMoney(inner,money);
                accountDao.payMoney(payer,money);
            }
        }) ;*/
        accountDao.collectMoney(inner,money);
        int i= 1/0 ;
        accountDao.payMoney(payer,money);
    }
```



**步骤：**

1. 配置管理器

```xml
<!-- 1 事务管理器 -->
<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

2. 配置事务详情

```xml
<!-- 2 事务详情（事务通知）  ， 在aop筛选基础上，比如对ABC三个确定使用什么样的事务。例如：AC读写、B只读 等
   <tx:attributes> 用于配置事务详情（属性属性）
      <tx:method name=""/> 详情具体配置
           propagation 传播行为 ， REQUIRED：必须；REQUIRES_NEW:必须是新的
           isolation 隔离级别
-->
<tx:advice id="txAdvice" transaction-manager="txManager">
    <tx:attributes>
        <tx:method name="transfer" propagation="REQUIRED" isolation = "DEFAULT"/>
    </tx:attributes>
</tx:advice>
```

3. 配置**AOP**

```xml
 <!-- 3 AOP编程，利用切入点表达式从目标类方法中 确定增强的连接器，从而获得切入点 -->
<aop:config>
    <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.ys.service..*.*(..))"/>
</aop:config>
```

### (3) 基于注解的方式@Transactional

可以标注在方法上，也可以标注在类上。

**开启注解扫描：**

```xml
<!-- 开启IOC容器的扫描 -->
<context:component-scan base-package="com.zzt"/>
<!-- 开启注解事物 -->
<tx:annotation-driven transaction-manager="transactionManager"/>
```

业务层代码：

```java
/**
 * 		注解该类为事物类( 参数类型如下 )		数据类型
 * 		propagation:   事物的传播行为		Propagation	
 * 		isolation:     事物的隔离级别		Isolation
 * 		readOnly:      是否只读			   boolean
 * 		rollbackFor:   被回滚的异常类型		Class[]
 * 		noRollbackFor: 不会滚的异常类型		String[]
 * 		timeout							   int
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    @Qualifier("accountDao")
    private AccountDao accountDao ;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    //转账业务
    @Override
    public void transfer(final String payer, final String inner, final long money) {

        accountDao.collectMoney(inner,money);
        //int i= 1/0 ;
        accountDao.payMoney(payer,money);
    }
}
```

**事务细节：**

|   @Transactional属性   |  数据类型   |                             描述                             |     取值范围      |
| :--------------------: | :---------: | :----------------------------------------------------------: | :---------------: |
|       isolation        |  Isolation  |                        事物的隔离级别                        |                   |
|      propagation       | Propagation |                        事物的传播行为                        |                   |
|     noRollbackFor      |   Class[]   |                 指定异常事务不回滚的异常类型                 |  Exception.class  |
| noRollbackForClassName |  String[]   |                                                              |                   |
|      rollbackFor       |   Class[]   | 指定异常事务回滚的异常类型                                       （运行时异常：默认回滚事务，编译时异常：默认不回滚） |  Exception.class  |
|  rollbackForClassName  |  String[]   |                                                              |                   |
|        readOnly        |   boolean   |                    设置事务是否是只读事务                    | true\|false(默认) |
|        timeout         |     int     |                             超时                             |    单位：秒(s)    |