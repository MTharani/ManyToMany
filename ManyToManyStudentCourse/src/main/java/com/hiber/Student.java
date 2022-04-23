package com.hiber;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="hiberstudent")
public class Student 
{
   @Id
   @Column(name="sid")
   private int id;
   @Column(length=30)
   private String sname;
   @Column(length=10)
   private long smobile;
public Student(int id, String sname, long smobile) {
	super();
	this.id = id;
	this.sname = sname;
	this.smobile = smobile;
}
public Student() {
	super();
}
@ManyToMany
   Set<Course>courselist;
@JoinTable(name="hiberstudent_hibercourse",
           joinColumns = { @JoinColumn(name="id",referencedColumnName = "sid")},
           inverseJoinColumns = {@JoinColumn(name="id",referencedColumnName = "cid")})
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public long getSmobile() {
	return smobile;
}
public void setSmobile(long smobile) {
	this.smobile = smobile;
}
public Set<Course> getCourselist() {
	return courselist;
}
public void setCourselist(Set<Course> courselist) {
	this.courselist = courselist;
}
@Override
public String toString() {
	return "Student [id=" + id + ", sname=" + sname + ", smobile=" + smobile + ", courselist=" + courselist + "]";
}
   
   
}
