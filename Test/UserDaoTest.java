package com.ecomm.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.pro.dao.CategoryDao;
import org.pro.dao.UserDao;
import org.pro.model.Category;
import org.pro.model.UserDetail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest
{
	 static UserDao userdao;

		@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("org.pro");
	context.refresh();

	userdao=(UserDao)context.getBean("userDao");
	}
	
	@Test
	public void registeruserTest()
	{
	UserDetail userdetail=new UserDetail();
	userdetail.setAddress("velachery");
	userdetail.setEmaild("frtg.@gmail.com");
	userdetail.setCustomerName("Kavi");
	userdetail.setMobileNumber("8766443243");
	userdetail.setUserName("Tamilselvi");
	userdetail.setPassword("iuygfds5r6ty");
	userdetail.setRole("user_user");
	
	
	 assertTrue("problem in adding the userdetail",userdao.registeruser(userdetail));
	}
    @Ignore
	@Test
	public void UpdateuserTest()
	{
		UserDetail user=userdao.getusers("Tamilselvi");
		user.setCustomerName("madhu");
		user.setMobileNumber("9876543678");

		 assertTrue("problem in adding the userdetail",userdao.updateuser(user));

	}
	
}
