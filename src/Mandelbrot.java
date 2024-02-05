public class Mandelbrot {
    
    public static int iterationLimit = 500;

    public static int testPoint(Complex c){
        int iterationCounter = 1;
        Complex z;
        Complex Z = new Complex(0, 0);

        while(iterationCounter < iterationLimit){
            z = Z.square();
            Z = z.add(c);
            if(Z.abs() > 2){
                return iterationCounter;
            }else{
                iterationCounter++;
            }
        }

        return -1;
    }
}