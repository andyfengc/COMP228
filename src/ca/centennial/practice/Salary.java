package ca.centennial.practice;

public class Salary extends Employee {

	// this constructor is necessary because there is not default parameterless
	// constructor in parent class
	public Salary(String name, String address) {
		super(name, address);
	}

	public static void main(String[] args) {
	}
	
	@Override
	public void displayMailAddress(){
		System.out.println("call from Salary Class");
		// the order of super is not important
		// in constructor, if we call super, it must go first.
		super.displayMailAddress();
	}

}

abstract class Employee {
	public Employee(String name, String address) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String name;
	private String address;

	public void displayMailAddress() {

	}
}