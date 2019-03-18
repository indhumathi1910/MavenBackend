package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.Model.Category;

@Repository
@Transactional
public class CategoryDAOImp implements CategoryDAO
{
@Autowired
SessionFactory sessionFactory;

@Override
public boolean addcategory(Category category) {
	// TODO Auto-generated method stub
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}

@Override
public boolean deletecategory(Category category) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().saveOrUpdate(category);
	try
	{
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

@Override
public boolean Updatecategory(Category category) {
	// TODO Auto-generated method stub
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

@Override
public List<Category> listcategories() 
{
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Category");
	List<Category>listcategories=query.list();
	session.close();
	return listcategories;
}




@Override
public Category getcategory(int categoryId) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	Category category=(Category)session.get(Category.class, categoryId);
	session.close();
	return category;
}

}
