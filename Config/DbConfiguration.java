package com.ecomm.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.Config")


public class DbConfiguration
{
	@Bean
	public DataSource getH2Datasources()
	{
		DriverManagerDataSource datasources=new DriverManagerDataSource();
		datasources.setDriverClassName("org.h2.Driver");
		datasources.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasources.setUsername("sa");
		datasources.setPassword("sa");
		System.out.println("Datasources object created");
		return datasources;
		}
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		hibernateprop.put("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2Datasources());
		factory.addProperties(hibernateprop);
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("SessionFactory object created");
		return sessionFactory;
	}
	@Bean("txt Manager")
	public HibernateTransactionManager getHibernateTransactionTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate transaction manager");
		return new HibernateTransactionManager(sessionFactory);	
		}

}
