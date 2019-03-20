package com.ecomm.Test;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.Product;
import com.ecomm.dao.ProductDAO;

public class ProductDAOTest
{
	
	 static ProductDAO productDao;

		@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("org.ecom");
	context.refresh();

	productDao=(ProductDAO)context.getBean("ProductDAO");
	}
		
	@Test
	public void addProductTest()
	{
	Product product=new Product();

	product.setProductName("NoteBook");
	product.setProductDesc("All authors books and notes are available");
	product.setPrice(50);
	product.setStock(300);
	product.setSupplierId(90);
	product.setCategoryId(7);
	 assertTrue("problem in adding the Product",productDao.addProduct(product));
	}
	@Ignore
	@Test
	public void UpdateProductTest()
	{
		Product product=productDao.getProduct(38);
		product.setProductName("candle");
		product.setProductDesc("Light");
        assertTrue("problem in adding the category",productDao.updateProduct(product));

	}
	@Ignore
	@Test
	public void DeleteProductTest()
	{
		Product product=productDao.getProduct(38);
		assertTrue("problem in adding the category",productDao.deleteProduct(product));
    }
	
	@Test
	public void listProductTest()
	{
		List<Product> listprod=productDao.listProduct();
		assertTrue("problem in adding the category",listprod.size()>0);
		for(Product product:listprod)
		{
			System.out.println(product);
		}
			}
		


}
