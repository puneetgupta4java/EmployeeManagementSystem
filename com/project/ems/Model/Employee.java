package com.project.ems.Model;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String password;
	private int age;
	private int salary;

	public Employee(int id, String name, String password, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.salary = salary;
	}

	public Employee() {
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", salary="
				+ salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.getId();
	}

}
