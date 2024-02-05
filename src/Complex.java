public class Complex {
    
    private double imaginaryNumber;
    private double realNumber;

    public Complex(double realNumber,double imaginaryNumber){
        this.imaginaryNumber = imaginaryNumber;
        this.realNumber = realNumber;
    }

    public Complex(){
       this.imaginaryNumber = 0;
       this.realNumber = 0; 
    }

    public Complex subtract(Complex other){
        return new Complex(this.realNumber - other.realNumber,this.imaginaryNumber - other.imaginaryNumber);
    }

    public Complex subtract(double other){
        return this.subtract(new Complex(other, 0));
    }

    public Complex divide(Complex other){
        //Used these for variables for easier understanding
        double a = this.realNumber;
        double b = this.imaginaryNumber;
        double c = other.realNumber;
        double d = other.imaginaryNumber;
        double real = ((a * c + b * d)/(c * c + d * d));
        double imaginaryNumber = (b * c - a * d)/(c * c + d * d);
        return new Complex(real, imaginaryNumber);
    }

    public Complex divide(double other){
        return this.divide(new Complex(other, 0));
    }

    public Complex add(Complex other){
        return new Complex(this.realNumber + other.realNumber, this.imaginaryNumber+other.imaginaryNumber);
    }

    public Complex add(double other){
        return this.add(new Complex(other, 0));
    }

    public Complex multiply(Complex other){
        //Used these for variables for easier understanding
        double a = this.realNumber;
        double b = this.imaginaryNumber;
        double c = other.realNumber;
        double d = other.imaginaryNumber;
        return new Complex(a * c - b * d, b * c + a * d);
    }

    public Complex multiply(double other){
        return this.multiply(new Complex(other, 0));
    }

    public Complex square(){
        return this.multiply(new Complex(this.realNumber, this.imaginaryNumber));
    }

    public double abs(){

        return Math.sqrt(this.realNumber * this.realNumber + this.imaginaryNumber * this.imaginaryNumber);
    }

    public double getReal(){
        return this.realNumber;
    }

    public double getImaginary(){
        return this.imaginaryNumber;
    }

    public boolean equals(Complex other){
        return this.realNumber == other.realNumber && this.imaginaryNumber == other.imaginaryNumber;
    }

    public String toString(){
        return realNumber + " + " + imaginaryNumber + "i";
    }
}
