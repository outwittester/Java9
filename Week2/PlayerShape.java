//创建三角形类，三个点，正方形名字，写一个方法计算正方形面积，要用polymorphism，要有一个shape, triangle, point的class，输入点的参数把面积算出来，point class中计算两点之间的距离
//triangle里面算三角形面积，point里面算两点距离
import java.util.*;

public class PlayerShape {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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

        Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
        double area = triangle.calculateArea();
        System.out.println("The area of the triangle is " + area);
    }
}

class Shape {
    private String name;
}

class PointsTwo {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public PointsTwo (double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        double dist = Math.sqrt(Math.pow((this.x1 - this.x2),2) + Math.pow((this.y1 - this.y2),2));
        return dist;
    }
}

class Triangle extends Shape {
    private double x1, x2, x3, y1, y2, y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double calculateArea() {
        PointsTwo ab = new PointsTwo(this.x1, this.y1, this.x2, this.y2);
        PointsTwo bc = new PointsTwo(this.x2, this.y2, this.x3, this.y3);
        PointsTwo cd = new PointsTwo(this.x1, this.y1, this.x3, this.y3);
        double abLength = ab.distance();
        double bcLength = bc.distance();
        double cdLength = cd.distance();
        double s = (abLength + bcLength + cdLength) / 2;
        double area = Math.sqrt(s * (s - abLength) * (s - bcLength) * (s - cdLength));
        return area;
    }

}