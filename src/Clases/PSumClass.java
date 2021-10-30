package Clases;

/**
 *
 * @author Samuel David Ortiz
 */
public class PSumClass {
    
    private double a;
    private double b;
    private double p;
    private double ab;

    public PSumClass(double a, double b, double p, double ab) {
        this.a = a;
        this.b = b;
        this.p = p;
        this.ab = ab;
    }

    public double calcular(){
        double Pa = this.a/this.p;
        double Pb = this.b/this.p;
        
        return Math.round((Pa + Pb - (this.ab/p))*100.0)/100.0;
    }
    
    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
    
    
    
}
