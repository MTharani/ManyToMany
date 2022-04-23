package com.hiber;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Course 
{
  @Id
  @Column(name="cid")
  private int id;
  @Column(length=35)
  private String cname;
  private double cprice;
public Course(int id, String cname, double cprice) {
	super();
	this.id = id;
	this.cname = cname;
	this.cprice = cprice;
}
public Course() {
	super();
}
@ManyToMany(mappedBy = "courselist")  //mapping =link 
  Set<Student>StudentList;   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public double getCprice() {
	return cprice;
}
public void setCprice(double cprice) {
	this.cprice = cprice;
}
public Set<Student> getStudentList() {
	return StudentList;
}
public void setStudentList(Set<Student> studentList) {
	StudentList = studentList;
}
@Override
public String toString() {
	return "Course [id=" + id + ", cname=" + cname + ", cprice=" + cprice + ", StudentList=" + StudentList + "]";
}
  
}
