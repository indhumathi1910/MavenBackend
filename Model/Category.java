package com.ecomm.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Category {
	@Id
	@GeneratedValue
	int categoryId;
	String categoryName;
	String categorydesc;
	public int getCategoryId()
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId=categoryId;
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	public String getCategorydesc()
	{
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc)
	{
		this.categorydesc=categorydesc;
	}

}
