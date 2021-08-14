package com.project.ems;

import java.util.List;
import java.util.Scanner;

import com.project.ems.Model.Employee;
import com.project.ems.processor.Admin;

public class EMS {
	public static void main(String[] args) {

		System.out.println("Welcome to EMS");
		String check = "yes";
		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		while (check.equalsIgnoreCase("yes")) {
			System.out.println(
					"What do you want to do :\n1. Add new Employee\n2. Read the List of Employees\n3. Update Employee\n4. Delete Employee");

			int value = sc.nextInt();

			switch (value) {
			case 1:
				System.out.println("Enter the details of the employee:-");
				System.out.println(admin.addEmployee(getEmployeeDetails()));
				break;
			case 2:
				System.out.println("Enter the sort type on which basis you want to see the list of employees: Id/Name/Age/Salary :");
				List<Employee> employees = admin.readEmployees(sc.next());
				employees.stream().forEach(System.out::println);
				break;
			case 3:
				System.out.println("Enter the id of the employee which you want to update:");
				int id = sc.nextInt();
				Employee employee = admin.findEmployee(id);
				if(employee != null) {
					Employee e = getEmployeeDetails();
					e.setId(id);
					System.out.println(admin.updateEmployee(e));
				}else {
					System.out.println("Employee not found");
				}
				break;
			case 4:
				System.out.println("Enter the id of the employee which you want to delete:");
				System.out.println(admin.deleteEmployee(sc.nextInt()));
				break;
			default:
				System.out.println("Invalid Operation");
				break;
			}

			System.out.println("Do you want to continue?\nYes\nNo");
			check = sc.next();
		}
		System.out.println("Thank you for using EMS");
	}

	private static Employee getEmployeeDetails() {
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter the name of the employee :");
		employee.setName(sc.next());
		System.out.println("Enter the password :");
		employee.setPassword(sc.next());
		System.out.println("Enter the age :");
		employee.setAge(sc.nextInt());
		System.out.println("Enter the salary :");
		employee.setSalary(sc.nextInt());
		return employee;
	}
}
