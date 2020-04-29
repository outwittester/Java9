import java.util.Scanner;

public class ShapeArea {
    public static void main(String[] args) {
        System.out.println("Type four points represented by x1, y1, x2, y2, x3, y3, x4, y4");
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
        System.out.println("x4");
        double x4 = Double.parseDouble(scanLine.nextLine());
        System.out.println("y4");
        double y4 = Double.parseDouble(scanLine.nextLine());
        System.out.println(args[0]);
        if (args.length == 0 || args == null) {
            System.out.println("Nothing in the argument");
        }
        else if (args[0].equals("1")) {
            Rectangle rectangle = new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4);
            System.out.println("The shape is " + rectangle.getName() + ", and the area is " + rectangle.getArea());

        }
        else if (args[0].equals("2")) {
            Trapezoid trapezoid = new Trapezoid(x1, y1, x2, y2, x3, y3, x4, y4);
            System.out.println("The shape is " + trapezoid.getName() + ", and the area is " + trapezoid.getArea());
        }
        else {
            System.out.println("Not a valid input");
        }

    }
}

abstract  class Quad {
    protected double x1, y1, x2, y2, x3, y3, x4, y4;
    public Quad(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;

    }
    abstract double getArea();
    abstract  String getName();

}

class Rectangle extends Quad {
    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    protected  String name = "Rectangle";
    protected double length = Math.sqrt(Math.pow((this.x3 - this.x4),2) + Math.pow((this.y3 - this.y4),2));
    protected double height = Math.abs(this.y2 - this.y4);
    protected  double area = 0;
    public String getName() {
        return this.name;
    }

    public double getArea() {
        this.area = this.length * this.height;
        return area;

    }
}

class Trapezoid extends Quad {
    public Trapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    protected  String name = "Trapezoid";
    protected double upperLength = Math.sqrt(Math.pow((this.x1 - this.x2),2) + Math.pow((this.y1 - this.y2),2));
    protected  double lowerLength = Math.sqrt(Math.pow((this.x3 - this.x4),2) + Math.pow((this.y3 - this.y4),2));
    protected double height = Math.abs(this.y2 - this.y4);
    protected  double area = 0;
    public String getName() {
        return this.name;
    }


    public double getArea() {
        this.area = (this.upperLength + this.lowerLength) * this.height / 2;
        return area;
    }
}

