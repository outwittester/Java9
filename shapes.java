package shape;

public class shapes {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(new Point(0,0), new Point(2,3), new Point(2,0), new Point(0,3));
        double width = rect.distanceCD();
        double height = rect.distanceAD();

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area of Rectangle: " + rect.area(width, height));

        Point p = new Point(1, 2);
        double see = p.getX();
        System.out.println("see: " + see);
        System.out.println("see2: " + rect.getpB().getX());
    }
}


class Triangle extends Shape {
    private Point pA;
    private Point pB;
    private Point pC;

    public void setpA(Point pA) {
        this.pA = pA;
    }

    public void setpB(Point pB) {
        this.pB = pB;
    }

    public void setpC(Point pC) {
        this.pC = pC;
    }

    public Point getpA() {
        return pA;
    }

    public Point getpB() {
        return pB;
    }

    public Point getpC() {
        return pC;
    }

    Triangle(){}

    Triangle(Point pA, Point pB, Point pC){
        this.pA = pA;
        this.pB = pB;
        this.pC = pC;
    }

    @Override
    public void draw() {
        System.out.println("triangle");
    }

    public double area(double height, double width) {
        return (double) (height * width) / 2;
    }

    public double distanceAB(){
        double pX = 0, pY = 0;
        pX = Math.abs(this.pA.getX() - this.pB.getX());
        pY = Math.abs(this.pA.getY() - this.pB.getY());
        return (double) (pX + pY) / 2;
    }

    public double distanceAC(){
        double pX = 0, pY = 0;
        pX = Math.abs(this.pA.getX() - this.pC.getX());
        pY = Math.abs(this.pA.getY() - this.pC.getY());
        return (double) (pX + pY) / 2;
    }

    public double distanceBC(){
        double pX = 0, pY = 0;
        pX = Math.abs(this.pB.getX() - this.pC.getX());
        pY = Math.abs(this.pB.getY() - this.pC.getY());
        return (double) (pX + pY) / 2;
    }
}

class Rectangle extends Shape {
    private Point pA;
    private Point pB;
    private Point pC;
    private Point pD;

    public Point getpA() {
        return pA;
    }

    public Point getpB() {
        return pB;
    }

    public Point getpC() {
        return pC;
    }

    public Point getpD() {
        return pD;
    }

    Rectangle(){}

    Rectangle(Point pA, Point pB, Point pC, Point pD){
        this.pA = pA;
        this.pB = pB;
        this.pC = pC;
        this.pD = pD;
    }

    @Override
    public void draw() {
        System.out.println("rectangle");
    }

    public double area(double length, double width) {
        return (double) length * width;
    }

    public double distanceAB(){
        double pX, pY;
        pX = Math.abs(this.pA.getX() - this.pB.getX());
        pY = Math.abs(this.pA.getY() - this.pB.getY());
        return (double) (pX + pY) / 2;
    }

    public double distanceBC(){
        double pX, pY;
        pX = Math.abs(this.pC.getX() - this.pB.getX());
        pY = Math.abs(this.pC.getY() - this.pB.getY());
        return (double) (pX + pY) / 2;
    }

    public double distanceCD(){
        double pX = 0, pY = 0;
        pX = Math.abs(this.pC.getX() - this.pD.getX());
        pY = Math.abs(this.pC.getY() - this.pD.getY());
        return (double) (pX + pY) / 2;
    }

    public double distanceAD(){
        double pX = 0, pY = 0;
        pX = Math.abs(this.pD.getX() - this.pA.getX());
        pY = Math.abs(this.pD.getY() - this.pA.getY());
        return (double) (pX + pY) / 2;
    }
}


class Point {
    private double x, y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

}

class Shape {
    private String name;

    public void draw() {
        System.out.println("shape");
    }

    public void area() {
        System.out.println("shape's area");
    }
}
