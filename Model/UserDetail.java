package com.ecomm.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class UserDetail 
{
	@Id
	String username;
	String password;
	String customerName;
	String role;
	String enable;
	String address;
	

}
