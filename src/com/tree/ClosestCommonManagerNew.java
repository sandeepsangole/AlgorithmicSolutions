package com.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*

In a company which has CEO Bill and a hierarchy of employees. Employees can have a list of other employees reporting to them,
which can themselves have reports, and so on. An employee with at least one report is called a manager.
Please implement the closestCommonManager method to find the closest manager (i.e. farthest from the CEO) to two employees.
 You may assume that all employees eventually report up to the CEO.


 Bill --> CEO
       /     |    \
    DOM      SAMIR  MICHAEL
   /  \   \
  Peter Bob Porter
 /     \
Milton Nina

 */

public class ClosestCommonManagerNew {


	public static void main(String args[]) {
		Employee bill = new Employee(1, "Bill");

		Employee dom    = new Employee(2, "Dom");
		Employee samir  = new Employee(3, "Samir");
		Employee michel = new Employee(4, "Michel");


		Employee peter  = new Employee(5, "Peter");
		Employee bob    = new Employee(6, "Bob");
		Employee porter = new Employee(7, "Porter");

		Employee milton = new Employee(8, "Milton");
		Employee nina   = new Employee(9, "Nina");

		bill.addReport(dom);
		bill.addReport(samir);
		bill.addReport(michel);

		dom.addReport(peter);
		dom.addReport(bob);
		dom.addReport(porter);

		peter.addReport(milton);
		peter.addReport(nina);


		Employee result = closestCommonManager(bill, nina, porter);

		System.out.print(result.getName());


	}


	public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
		Stack<Employee> firstPath  = new Stack<Employee>();
		Stack<Employee> secondPath = new Stack<Employee>();

		Employee root = ceo;

		DFS(root, firstEmployee, firstPath);
		DFS(root, secondEmployee, secondPath);

		if (firstPath.peek().getId() == firstEmployee.getId() && secondPath.peek().getId() == secondEmployee.getId()) {
			int size1 = firstPath.size();
			int size2 = secondPath.size();
			int diff  = Math.abs(size2 - size1);

			if (size1 > size2) {
				moveUp(firstPath, diff);
			} else {
				moveUp(secondPath, diff);
			}

			while (firstPath.peek().getId() != secondPath.peek().getId()) {
				firstPath.pop();
				secondPath.pop();
			}

			if (firstPath.size() > 0) {
				return firstPath.pop();
			}
		}
		return null;
	}

	private static boolean DFS(Employee root, Employee target, Stack<Employee> path) {

		path.push(root);
		if (root.getId() == target.getId()) {
			return true;
		}

		for (Employee r : root.getReports()) {
			boolean res = DFS(r, target, path);
			if (res) {
				return true;
			}
		}

		path.pop();

		return false;
	}

	private static void moveUp(Stack<Employee> path, int diff) {
		while (diff > 0 && !path.isEmpty()) {
			path.pop();
			diff--;
		}
	}


}

class Employee {

	private final int            id;
	private final String         name;
	private final List<Employee> reports;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		this.reports = new ArrayList<Employee>();
	}

	/**
	 * @return an integer ID for this employee, guaranteed to be unique.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return a String name for this employee, NOT guaranteed to be unique.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return a List of employees which report to this employee.  This list may be empty, but will
	 *      never be null.
	 */
	public List<Employee> getReports() {
		return reports;
	}

	/**
	 * Adds the provided employee as a report of this employee.
	 */
	public void addReport(Employee employee) {
		reports.add(employee);
	}
}
