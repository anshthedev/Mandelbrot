//Test cases for Complex.java
//These just make sure the Complex class is working as expected

public class ComplexUnitTest {

	public static void main(String[] args) {
		Complex c1 = new Complex();
		Complex c2 = new Complex(3,4);
		Complex c3 = c1.add(c2);
		Complex c4 = c3.add(1);
		Complex c5 = c1.subtract(c2);
		Complex c6 = c5.subtract(1);
		Complex c7 = c4.multiply(c6);
		Complex c8 = c2.multiply(-1);
		Complex c9 = c4.divide(c6);
		Complex c10 = c2.divide(2);
		Complex c11 = c3.square();
		System.out.println("No args constructor:\t"+c1.equals(new Complex(0,0)));
		System.out.println("Full args constructor:\t"+c2.equals(new Complex(3,4)));
		System.out.println("Add (complex):\t\t"+c3.equals(new Complex(3,4)));
		System.out.println("Add(real):\t\t"+c4.equals(new Complex(4,4)));
		System.out.println("Subtract (complex):\t"+c5.equals(new Complex(-3,-4)));
		System.out.println("Subtract (real):\t"+c6.equals(new Complex(-4,-4)));
		System.out.println("Multiply (complex):\t"+c7.equals(new Complex(0,-32)));
		System.out.println("Multiply (real): \t"+c8.equals(new Complex(-3,-4)));
		System.out.println("Divide (complex): \t"+c9.equals(new Complex(-1,0)));
		System.out.println("Divide (real): \t\t"+c10.equals(new Complex(1.5,2)));
		System.out.println("Square: \t\t"+c11.equals(new Complex(-7,24)));
		System.out.println("Abs: \t\t\t"+(c11.abs()==25.0));	
	}

}