package com.raj.shashi.domain;

/**
 * @author vagrant
 *
 */
public class Employee {

	private String empId;
	private String empName;
	private String gender;

	public Employee() {
		super();
	}

	public Employee(String empId, String empName, String gender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + "]";
	}

}
