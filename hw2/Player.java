import java.util.*;
public class Player {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type 1 for line, 2 for triangle");
        int flag = scan.nextInt();
        if (flag == 1) {
            System.out.println("Type two points represented by x1, y1, x2, y2");
            Scanner scanLine = new Scanner(System.in);
            System.out.println("x1");
            double x1 = Double.parseDouble(scanLine.nextLine());
            System.out.println("y1");
            double y1 = Double.parseDouble(scanLine.nextLine());
            System.out.println("x2");
            double x2 = Double.parseDouble(scanLine.nextLine());
            System.out.println("y2");
            double y2 = Double.parseDouble(scanLine.nextLine());
            Line line = new Line();
            line.setX1(x1);
            line.setX2(x2);
            line.setY1(y1);
            line.setY2(y2);
            System.out.println("the shape is ");
            line.draw();
            System.out.println("The distance is: " + line.getDistance());
        }
        if (flag == 2) {
            System.out.println("Type three points represented by x1, y1, x2, y2, x3, y3");
            Scanner scanLine = new Scanner(System.in);
            System.out.println("x1");
            double x1 = Double.parseDouble(scanLine.nextLine());
            System.out.println("y1");
            double y1 = Double.parseDouble(scanLine.nextLine());
            System.out.println("x2");
            double x2 = Double.parseDouble(scanLine.nextLine());
            System.out.println("y2");
            double y2 = Double.parseDouble(scanLine.nextLine());
            System.out.println("x3");
            double x3 = Double.parseDouble(scanLine.nextLine());
            System.out.println("y3");
            double y3 = Double.parseDouble(scanLine.nextLine());

            Triangle triangle = new Triangle();
            triangle.setX1(x1);
            triangle.setX2(x2);
            triangle.setY1(y1);
            triangle.setY2(y2);
            triangle.setX3(x3);
            triangle.setY3(y3);
            System.out.println("the shape is ");
            triangle.draw();
            System.out.println("The area is: " + triangle.getArea());
        }


    }
}

class Shape {
    protected String type;
    public Shape () {
    }
    public void draw() {
        System.out.println(this.type);
    }
}

class Line extends Shape{
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double distance;
    public Line() {
        this.type = "Line";
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getDistance() {
        this.distance = Math.sqrt(Math.pow((this.x1 - this.x2),2) + Math.pow((this.y1 - this.y2),2));
        return distance;
    }

}

class Triangle extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double area;

    public Triangle() {
        this.type = "Triangle";
    }


    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getArea() {
        this.area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
        return area;
    }
}



