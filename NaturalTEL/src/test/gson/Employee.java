package test.gson;

import java.io.Serializable;

/**
 * name:員工類別
 */
public class Employee implements Serializable {
	// constructor
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	// employ's attribute
	private String name;
	private int age;
	private String sex;
	private double salary;

	// setter and getter
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.append("name:" + name);
		sb.append("age:" + age);
		sb.append("sex:" + sex);
		sb.append("salary:" + salary);
		sb.append("");
		return sb.toString();
	}
}