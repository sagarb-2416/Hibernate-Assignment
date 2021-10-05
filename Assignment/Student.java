package com.mini.project;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	private int roll_no;

	private String name;
	
	private long mobile_no;
	
	private String standard;
	
	private String DOB;
	
	public Student() {
		super();
	}

	public Student(int roll_no, String name, long mobile_no, String standard, String dOB) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.mobile_no = mobile_no;
		this.standard = standard;
		DOB = dOB;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (mobile_no != other.mobile_no)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roll_no != other.roll_no)
			return false;
		if (standard == null) {
			if (other.standard != null)
				return false;
		} else if (!standard.equals(other.standard))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + (int) (mobile_no ^ (mobile_no >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roll_no;
		result = prime * result + ((standard == null) ? 0 : standard.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", mobile_no=" + mobile_no + ", standard=" + standard
				+ ", DOB=" + DOB + "]";
	}

	
}
