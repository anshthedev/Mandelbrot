/* View Unit Test
 * version 6.1
 * 
 */

 public class ViewUnitTest {

    public static void main(String[] args) {
        View v = new View(600, 400);
        
        System.out.println("These points test the default view:");
        Complex c = v.translate(0, 0);
        System.out.println("(0,0) -> (-2,1i): \tgot "+c+"\t\t" + c.equals(new Complex(-2, 1)));
        c = v.translate(300, 200);
        System.out.println("(300,200) -> (-0.5,0i): got "+c+"\t\t" + c.equals(new Complex(-0.5, 0)));
        c = v.translate(600, 400);
        System.out.println("(600,400) -> (1,-1i): \tgot "+c+"\t\t" + c.equals(new Complex(1, -1)));
        c = v.translate(0, 400);
        System.out.println("(0,400) -> (-2,-1i): \tgot "+c+"\t" + c.equals(new Complex(-2, -1)));
        c = v.translate(600, 0);
        System.out.println("(600,0) -> (1,1i): \tgot "+c+"\t\t" + c.equals(new Complex(1, 1)));
        System.out.println();
        System.out.println("These points test the view after a zoom to (-1,1)-(-1.6,1.4):");
        v.setComplexCorners(new Complex(-1, 1), new Complex(-1.6, 1.4));
        c = v.translate(50, 80);
        System.out.println("(50,80) -> (-1.05,1.08i): got "+c+"\t" + c.equals(new Complex(-1.05, 1.08)));
        c = v.translate(100, 40);
        System.out.println("(100,40) -> (-1.1,1.04i): got "+c+"\t" + c.equals(new Complex(-1.1, 1.04)));
        c = v.translate(0, 0);
        System.out.println("(0,0)    -> (-1,1i): \t  got "+c+"\t" + c.equals(new Complex(-1, 1)));
        c = v.translate(300, 200);
        System.out.println("(300,200) -> (-1.3,1.2i): got "+c+"\t" + c.equals(new Complex(-1.3, 1.2)));
        c = v.translate(600, 400);
        System.out.println("(600,400) -> (-1.6,1.4i): got "+c+"\t" + c.equals(new Complex(-1.6, 1.4)));
        c = v.translate(0, 400);
    }

}