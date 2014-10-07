package ca.centennial.practice;

/**
 * Abstract class test
 * 
 * @author 300720952
 * 
 */

public class Salary extends Employee {

	// this constructor is mandatory because there is not default parameterless
	// constructor in parent class
	public Salary(String name, String address) {
		super(name, address);
	}

	public static void main(String[] args) {
		// initiate a Employee object
		Employee e1 = new Employee("Andy", "939 Progress Avenue") {

			@Override
			public double calculatePayment() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		// initiate another Employee object
		Employee e2 = new Salary("Kevin", "1929 Ellesmere Ave.");
	}

	@Override
	public void displayMailAddress() {
		System.out.println("call displayMailAddress() from Salary Class");
		// the order of super is not important
		// but in constructor, the order of super is important - must go first.
		super.displayMailAddress();
	}

	// this method is mandatory because it is abstract in super class
	@Override
	public double calculatePayment() {
		return 0;
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
		System.out.println("call displayMailAddress() from Employee Class");
	}

	public abstract double calculatePayment();
}