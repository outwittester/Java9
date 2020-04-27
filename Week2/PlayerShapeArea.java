//长方形，梯形，user通过不同input得到不同的形状，并计算面积
// p1    p2
// p3    p4

import java.util.*;

public class PlayerShapeArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("If rectangle input 1, if trapezoid input 2:");
        int flag = Integer.parseInt(scan.nextLine());
        System.out.println("x1");
        double x1 = Double.parseDouble(scan.nextLine());
        System.out.println("y1");
        double y1 = Double.parseDouble(scan.nextLine());
        System.out.println("x2");
        double x2 = Double.parseDouble(scan.nextLine());
        System.out.println("y2");
        double y2 = Double.parseDouble(scan.nextLine());
        System.out.println("x3");
        double x3 = Double.parseDouble(scan.nextLine());
        System.out.println("y3");
        double y3 = Double.parseDouble(scan.nextLine());
        System.out.println("x4");
        double x4 = Double.parseDouble(scan.nextLine());
        System.out.println("y4");
        double y4 = Double.parseDouble(scan.nextLine());

        String name = "";
        double area = 0;

        if (flag == 1) {
            Rectangle rectangle = new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4);
            area = rectangle.calculateArea();
            name = "rectangle";
        }
        else if (flag == 2) {
            Trapezoid trapezoid = new Trapezoid(x1, y1, x2, y2, x3, y3, x4, y4);
            area = trapezoid.calculateArea();
            name = "trapezoid";
        }

        System.out.println("The area of the " + name + " is " + area);

    }
}


class Shape2 {
    private double x1, y1, x2, y2, x3, y3, x4, y4;
    public Shape2(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    public double bottomLength() {
        double dist = Math.sqrt(Math.pow((this.x3 - this.x4),2) + Math.pow((this.y3 - this.y4),2));
        return dist;
    }

    public double topLength() {
        double dist = Math.sqrt(Math.pow((this.x1 - this.x2),2) + Math.pow((this.y1 - this.y2),2));
        return dist;
    }

    public double height() {
        return Math.abs(this.y2 - this.y4);
    }

}

class Rectangle extends Shape2 {
    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double calculateArea() {
        double bottom = bottomLength();
        double top = topLength();
        double h = height();
        double area = bottom * h;
        return area;
    }
}

class Trapezoid extends Shape2 {
    public Trapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double calculateArea() {
        double bottom = bottomLength();
        double top = topLength();
        double h = height();
        double area = (bottom + top) * h / 2;
        return area;
    }

}


