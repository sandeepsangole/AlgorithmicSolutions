package com.tree.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class ClosestCommonManager {

	Employee ceo;

	Employee findClosestCommonManager(Employee root,Employee e1 , Employee e2) {
		Employee currentClosestManager = ceo;
		if (ceo == null || e1 == null || e2 == null) {
			return null;
		} else if (e1.equals(ceo) || e2.equals(ceo)) {
			return ceo;
		} else {
			//Traverse Level1 - CEO

			Queue<Employee> queue = new LinkedList<Employee>();
			queue.offer(ceo);
			while (!queue.isEmpty()) {
				Employee boss = queue.peek();

				for (Employee e : root.getReportees()) {
					if(covers(e,e1) && covers(e,e2)){
						currentClosestManager =  e;
						System.out.println("currentClosestManager :"+currentClosestManager.getName());
						return currentClosestManager;
					}
				}


			}
		}
return currentClosestManager;
	}

	public static boolean covers(Employee root, Employee p){

		if(root == null)
			return false;

		if(root.getName().equals(p.getName()))
			return true;


		if(root.getReportees() == null) return false;

		for(Employee e : root.getReportees()){
			if(covers(e,p)) {
				System.out.println(p.getName() +"is Covered Under : "+e.getName());
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]){
		ClosestCommonManager manager  = new ClosestCommonManager();
		Employee bill = new Employee("Bill");
		bill.setLevel(1);

		Employee dom = new Employee("Dom");
		dom.setLevel(2);
		Employee samir = new Employee("Samir");samir.setLevel(2);
		Employee michel = new Employee("Michel");michel.setLevel(2);


		Employee peter = new Employee("Peter"); peter.setLevel(3);
		Employee bob = new Employee("Bob");bob.setLevel(3);
		Employee porter = new Employee("Porter");porter.setLevel(3);

		Employee milton = new Employee("Milton");milton.setLevel(4);
		Employee nina = new Employee("Nina");nina.setLevel(4);

		bill.setReportees(Arrays.asList(dom,samir,michel));
		dom.setReportees(Arrays.asList(peter,bob,porter));
		peter.setReportees(Arrays.asList(milton,nina));

		manager.ceo = bill;

		manager.findClosestCommonManager(manager.ceo,samir,milton);
	}
}

class Employee{
	private String name;
	private List<Employee> reportees;
	private int level;

	Employee(){

	}

	Employee(String name){
		this.name = name;
	}

	Employee(String name , List<Employee> reportees,int level){
		this.name = name;
		this.reportees = reportees;
		this.level = level;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public List<Employee> getReportees(){
		return this.reportees;
	}

	public void setReportees(List<Employee> reportees)
	{
		this.reportees = reportees;
	}

	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

}
