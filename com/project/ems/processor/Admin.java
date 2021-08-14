package com.project.ems.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.project.ems.Model.Employee;
import com.project.ems.comparator.AgeComparator;
import com.project.ems.comparator.NameComparator;
import com.project.ems.comparator.SalaryComparator;

public class Admin {

	private int id = 0;
	private List<Employee> employees = new ArrayList<>();

	public String addEmployee(Employee employee) {
		id++;
		employee.setId(id);
		employees.add(employee);
		return "Employee with id " + id + " is added successfully";
	}

	public List<Employee> readEmployees(String sortType) {
		switch (sortType.toUpperCase()) {
		case "ID":
			Collections.sort(employees);
			break;
		case "NAME":
			Collections.sort(employees, new NameComparator());
			break;
		case "AGE":
			Collections.sort(employees, new AgeComparator());
			break;
		case "SALARY":
			Collections.sort(employees, new SalaryComparator());
			break;
		default:
			break;
		}
		return employees;
	}

	public Employee findEmployee(int id) {
		for (Employee e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public String updateEmployee(Employee employee) {
		for (Employee e : employees) {
			if (e.getId() == employee.getId()) {
				e.setName(employee.getName());
				e.setAge(employee.getAge());
				e.setPassword(employee.getPassword());
				e.setSalary(employee.getSalary());
				return "Employee " + employee.getName() + " updated successfully";
			}
		}
		return "something went wrong";
	}

	public String deleteEmployee(int id) {
		Employee employee = null;
		for (Employee e : employees) {
			if (e.getId() == id) {
				employee = e;
			}
		}
		if (employee != null) {
			employees.remove(employee);
			return "Employee " + employee.getName() + " deleted successfully";
		}
		return "Employee not found";
	}
}
