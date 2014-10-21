package ca.centennial.test;

import java.util.Formatter;

public class FormatterTester {
	public static void main(String[] args){
		Formatter fmt = new Formatter();
		fmt.format("%.10f", Math.PI);
		System.out.println(fmt);
		fmt.close();
		Formatter fmt2 = new Formatter();
		fmt2.format("%10.2f", Math.PI);
		System.out.println(fmt2);
		fmt2.close();
	}
}
