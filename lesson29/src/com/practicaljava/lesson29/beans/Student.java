package com.practicaljava.lesson29.beans;

import java.io.BufferedReader;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int studentId;
	String name;
	long classId;
	
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public long getClassId() {
		return classId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	
	public boolean take(BufferedReader firstImage, BufferedReader secondImage){
		
		return false;
	}
	
}
