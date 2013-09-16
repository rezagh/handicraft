package com.handicraft.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



public class BaseTest {
	public ApplicationContext applicationContext;
	BeanFactory factory;
	
	public BaseTest() {
		//ClassPathResource resource = new ClassPathResource("spring-config-test.xml");
		//factory = new XmlBeanFactory(resource);
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"test-spring-config.xml"});
		
		Resource xmlResource = new FileSystemResource("WEB-INF/test-spring-config.xml");
        factory = new XmlBeanFactory(xmlResource);
        //Employee employeeBean = (Employee)factory.getBean("employeeBean");
	}
	
	
}
