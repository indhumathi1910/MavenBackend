package com.ecomm.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.Supplier;
import com.ecomm.dao.SupplierDAO;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class SupplierDaoTest 
{
	static SupplierDAO supplierdao;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Indhu");
		supplier.setSupplierAddress("Vpm");
		assertTrue("Problem in adding the supplier",supplierdao.add(supplier));
		
	}
	@Test
	public void UpdateSupplierTest()
	{
		Supplier supplier=supplierdao.getSupplier(40);
		supplier.setSupplierName("Karthi");
		supplier.setSupplierAddress("chennai");
		assertTrue("problem in adding the category",supplierdao.update(supplier));
		
	}
@Ignore
@Test
public void DeleteCategoryTest()
{
	Supplier supplier=supplierdao.getSupplier(137);
	supplier.setSupplierName("Murugan");
	supplier.setSupplierAddress("Madurai");
	assertTrue("Problem in adding the category",supplierdao.delete(supplier));
}
public void listCategoriesTest()
{
	List<Supplier>listsupplier=supplierdao.listsupplier();
	assertTrue("Problem in adding the category",listsupplier.size()>0);
	for(Supplier supplier:listsupplier)
	{
		System.out.println(listsupplier);
	}
}

}
