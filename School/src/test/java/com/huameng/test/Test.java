package com.huameng.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.huameng.bean.Student;
import com.huameng.mybatis.Page;
import com.huameng.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class Test {
	private static Logger logger = Logger.getLogger(Test.class);
	private ApplicationContext ac = null;
    @Resource  
    private StudentService studentService = null;
  @Before  
  public void before() {  
      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
      studentService = (StudentService) ac.getBean("studentService");  
  } 
    
    
    @org.junit.Test  
    public void test1() {  
        Page<Student> user = studentService.selectStudentPageAll(1);  
        System.out.println(user.getResults());  
        // logger.info("Öµ£º"+user.getUserName());  
        logger.info(JSON.toJSONString(user));  
    }
    public static void main(String[] args) {
		Test t=new Test();
		t.before();
		t.test1();
	}
    
    
    
    
}
