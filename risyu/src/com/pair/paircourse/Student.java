/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pair.paircourse;

import javax.jdo.annotations.*;

/**
 *
 * @author g14911ih
 */
public class Student {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long studentId;
	@Persistent
	private String name;
	@Persistent
	private Long id;
    
    public Student(String name,long id) {
    	super();
        this.name = name;
        this.id = id;
	}

	public Long getStudentId(){
        return studentId;
    }
    public void setStudentId(Long id){
    	studentId = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}
}
