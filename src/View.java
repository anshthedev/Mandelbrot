public class View{

    int screenWidth, screenHeight;
    double xSlope, xOffset, ySlope, yOffset;
    
    public View(int w, int h){
    
        screenWidth = w;
        screenHeight = h;
        setComplexCorners(new Complex(-2,1),new Complex(1,-1));
    
    }
    
    public Complex translate(int x, int y){
        double real = xSlope * x + xOffset;
        double imag = ySlope * y + yOffset;
        return new Complex(real, imag);
    
    }
    
    public void setComplexCorners(Complex topLeft, Complex botRight){
        xOffset = topLeft.getReal();
        xSlope = (botRight.getReal() - topLeft.getReal())/this.screenWidth;
        yOffset = topLeft.getImaginary();
        ySlope = (botRight.getImaginary() - topLeft.getImaginary())/this.screenHeight;
    }
}