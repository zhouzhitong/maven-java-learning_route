# Spring MVC

# 一、入门案例：

## 操作步骤：

### 1. 导入依赖

```xml
  <properties>
    <spring.version>5.0.2.RELEASE</spring.version>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>
      <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>
```



### 2. 编写springmvc.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
            http://www.springframework.org/schema/mvc
            http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context-3.2.xsd">
    <!-- 激活@Required @Autowired @Resource等标注-->
    <context:annotation-config></context:annotation-config>
    <!-- DispatcherServlet上下文，扫描base-package包中的类，并自动加载到spring容器中 -->
    <!--
        <context:component-scan/>
        标签是告诉Spring 来扫描指定包下的类，并注册被@Component，@Controller，@Service，@Repository等注解标记的组件。
    -->
    <context:component-scan base-package="com.atguigui.controller">
    </context:component-scan>
    
    <!--   启用@Component，@Controller，@Service，@Repository注解驱动 -->
    <mvc:annotation-driven/>

    <!-- 配置视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    
</beans>
```



### 3. 编写web.xml配置文件

```xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
  <display-name>Archetype Created Web Application</display-name>

  <!-- 前端控制器 -->
  <servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 加载SpringMVC配置 -->
    <init-param>
      <!-- 配置文件的位置 -->
      <!-- 如果不配置contextConfigLocation, 默认查找的配置文件名称classpath下的: servlet名称+"servlet.xml"即springmvc-servlet.xml -->
      <param-name>contextConfigLocation</param-name>
      <param-value>/WEB-INF/configs/springmvc.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <!-- 可以配置/, 此工程 所有请求全部由spring mvc解析，此种方式可以实现 RESTful方式，需要特殊处理对静态文本的解析不能由spring mvc解析
        可以配置*.do或*.action, 所有请求的url扩展名为.do或.action由spring mvc解析，此种方法 不可以使用/*,如果配置/*，返回的jsp也由spring mvc解析，这是不对的 -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>
```

### 4. 编写表现层逻辑

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%  String path=request.getContextPath(); %>
</head>
<body>
<a href="<%=path%>/userAction/login.action">点我跳转</a>
</body>
</html>
```

```java
@Controller
@RequestMapping(value="/userAction")
public class UserController {
    @RequestMapping(value="/login.action")
    public String login(){
        System.out.println("用户登录");
        return "success";
    }
}
```



# 二、重要注解

## 1. @RequestMapping

 		`@RequestMapping`是一个用来处理请求地址映射的注解，可用于**类**或**方法**上。用于类上，表示类中的所有响应请求的方法都是以该地址作为**父路径**。 

​		 RequestMapping注解有六个属性（分成三类进行说明）与六个基本用法， 

### (1)  六个属性 

**1、 value， method；**

​		value：   指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；

​		method： 指定请求的method类型， GET、POST、PUT、DELETE等；

​	说明：

​		value的uri值为以下三类：

​				A） 可以指定为普通的具体值；

​				B) 可以指定为含有某变量的一类值(URI Template Patterns with Path Variables)；

​				C) 可以指定为含正则表达式的一类值( URI Template Patterns with Regular Expressions); 

**2、 consumes，produces；**

​		consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;

​		produces:  指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

**3、 params，headers；**

​		params： 指定request中必须包含某些参数值是，才让该方法处理。

​		headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。

### (2) 用法

**1) 基本用法：**

```java
@RequestMapping(value="/departments")  
public String simplePattern(){  
  System.out.println("simplePattern method was called");  
  return "someResult";  
}
```

**2) 参数绑定:** 

```java
@RequestMapping(value="/departments")  
public String findDepatment(@RequestParam("departmentId") String departmentId){  
    System.out.println("Find department with ID: " + departmentId);  
    return "someResult";  
}
```

**3) REST风格的参数**  

```java
@RequestMapping(value="/departments/{departmentId}")  
public String findDepatment(@PathVariable String departmentId){  
  System.out.println("Find department with ID: " + departmentId);  
  return "someResult";  
}
```

**4) REST风格的参数绑定形式之2**

```java
@RequestMapping(value="/departments/{departmentId}")  
public String findDepatmentAlternative(
    @PathVariable("departmentId") String someDepartmentId){  
    System.out.println("Find department with ID: " + someDepartmentId);  
    return "someResult";  
}
```

**5) url中同时绑定多个id**

```java
@RequestMapping(value="/departments/{departmentId}/employees/{employeeId}")  
public String findEmployee(@PathVariable String departmentId,
                           @PathVariable String employeeId){  
    System.out.println("Find employee with ID: " + employeeId +   
      " from department: " + departmentId);  
    return "someResult";  
}
```

**6) 支持正则表达式**

```java
@RequestMapping(value="/{textualPart:[a-z-]+}.{numericPart:[\\d]+}")  
public String regularExpression(@PathVariable String textualPart,
                                @PathVariable String numericPart){  
    System.out.println("Textual part: " + textualPart + 
                       ", numeric part: " + numericPart);  
    return "someResult";
}
```

## 2. @CookieValue("...")

```java
//Controller
@RequestMapping("/test")
public String cookieTest(
    @CookieValue(value="..." /*,required=false*/) String value){
    System.out.println("Cookie:"+value);
    return "success" ;
}

```



## 3. @SeesionAttributes（不常用）

**（只能标注在类上）**

`@SeesionAttributes(value="msg")`

给`BindingAwareModelMap`，或`ModelAndView`中保存的数据，同时给`session`保存一份

**属性：**

1. value[]

指定保存数据的**KEY**

2. types[]

指定保存的数据类型



## 4. @ModelAttribute

参考网址：[https://www.cnblogs.com/jasonZh/p/8761432.html](https://www.cnblogs.com/jasonZh/p/8761432.html)



# 三、Rest风格

## 1. 例如员工信息操作

|      需求      |  请求URI  | 请求方式 |
| :------------: | :-------: | :------: |
| 查询某员工信息 | /emp/{id} |   GET    |
|      添加      |   /emp    |   POST   |
|      删除      | /emp/{id} |  DELETE  |
|      修改      | /emp/{id} |   PUT    |

## 2. web.xml配置文件添加的过滤器

```xml
<filter>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



## 3. 操作的HTML页面

（简单模拟）

```html
<a href="/emp/{1}">查询1号员工信息</a>
<form action="/emp" method="post">
    <input type="submit" value="添加1号员工信息"/>
</form>
<form action="/emp/1" method="post">
    <input type="hiden" name="_method" value="delete"/>
    <input type="submit" value="删除1号员工信息"/>
</form>
<form action="/emp/1" method="post">
    <input type="hiden" name="_method" value="put"/>
    <input type="submit" value="更新1号员工信息"/>
</form>
```



## 4. 表现成逻辑

```java
@Controller
public class EmployeeController{
    // 查询员工信息
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET )
    pulic String getEmp(@PathVariable Integer id){
        System.out.println("(模拟)查询了"+id+"员工信息");
    	return "success" ;
    }
    // 保存员工信息
    @RequestMapping(value="/emp",method=RequestMethod.POST)
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:/emps";
    }
    // 修改
    @RequestMapping(value="/emp",method=RequestMethod.PUT)
    public String update(Employee employee){

        employeeService.save(employee);
        return "redirect:/emps";
    }
    // 删除员工信息
    @RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
```



# 四、处理模型数据



## 1、Model、Map、ModelMap

数据放入，请求域中(request)





## 2、ModelAndView

```java
@RequestMapping("/handle")
public ModelAndView handle(){
    ModelAndView view = new ModelAndView("success");
    //view.setViewName("success");
    mv.addObject("msg","ModelAndView中的数据");
    return view ;
}
```

携带数据放入，请求域中(request)





3、



