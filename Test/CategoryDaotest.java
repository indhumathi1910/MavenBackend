package com.ecomm.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.Category;
import com.ecomm.dao.CategoryDAO;


class CategoryDaotest 
{
static CategoryDAO categoryDao;
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	categoryDao=(CategoryDAO)context.getBean("categoryDAO");
	
	}
@Test
public void addcategorytest()
{
	Category category=new Category();
	category.setCategoryId(1);
	category.setCategoryName("Samsung");
	category.setCategorydesc("All smart mobile of samsung brand");
			assertTrue("Problem in adding category",categoryDao.addcategory(category));
	
}
@Test
public void deleteCategoryTest()
{
	Category category=categoryDao.getcategory(2);
	assertTrue("Problem in deleting the category",categoryDao.deletecategory(category));
}
@Test
public void UpdateCategoryTest()
{
	Category category=categoryDao.getcategory(3);
	category.setCategorydesc("All the smart mobile");
	assertTrue("Problem in updating the category",categoryDao.Updatecategory(category));
	
}
@Test
public void retriveCategoriesTest()
{
	List<Category> ListCategories=categoryDao.listcategories();
	assertTrue("problem in retrieving category",ListCategories.size()>0);
	for(Category category:ListCategories)
	{
		System.out.println(category.getCategoryId()+"");
		System.out.println(category.getCategoryName()+"");
		System.out.println(category.getCategorydesc()+"");
}
	
}

}
