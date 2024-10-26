package com.HibernateQueryCache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
 @Id
 int id;
 String name;
 int age;
 int mobileno;
 String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getMobileno() {
	return mobileno;
}
public void setMobileno(int mobileno) {
	this.mobileno = mobileno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileno=" + mobileno + ", address=" + address
			+ "]";
}
 
}
