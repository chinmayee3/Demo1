package com.demo.spring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "student")//table name is 
public class Student {
	@Id
	private int Roll_no;
	private String C_no;
	
	public int getRoll_no() {
		return Roll_no;
	}

	public void setRoll_no(int roll_no) {
		Roll_no = roll_no;
	}

	public String getC_no() {
		return C_no;
	}

	public void setC_no(String c_no) {
		C_no = c_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAttendance() {
		return Attendance;
	}

	public void setAttendance(int attendance) {
		Attendance = attendance;
	}

	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	private int Attendance;

}
