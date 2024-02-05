//Test cases for Mandelbrot.java
//These just make sure the Mandelbrot class is working as expected

public class MandelbrotUnitTest {

    public static void main(String[] args) {

        printResult(new Complex(0, 1), -1);
        printResult(new Complex(0, -1), -1);
        printResult(new Complex(1, 0), 3);
        printResult(new Complex(0, 2), 2);
        printResult(new Complex(0, -2), 2);
        printResult(new Complex(0.5, 0), 5);
        printResult(new Complex(0.251, 0), 97);
        printResult(new Complex(-1, 0.3), 35);
        printResult(new Complex(-0.75, 0.2), 16);
    }

    public static void printResult(Complex c, int correct) {
        int actual = Mandelbrot.testPoint(c);
        System.out.print("Results for " + c + " should be " + correct + ", got " + actual);
        System.out.println("\t" + (correct == actual));
    }

}