import java.awt.*;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Shape shape = new Shape();
        if (args[0].equals("0")) {
            shape = new Quadrangle();
        } else if (args[0].equals("1")) {
            shape = new Rectangle();
        } else if (args[0].equals("2")) {
            shape = new Trapezoid();
        }


        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }
        System.out.println("-----");
        shape.draw();

    }
}


    class Quadrangle extends Shape {
        private String name;
        private Point pA;
        private Point pB;
        private Point pC;


        public void getArea() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入点1的坐标：");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            System.out.println("请输入点2的坐标：");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            System.out.println("请输入点3的坐标：");
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();
            System.out.println("请输入点4的坐标：");
            double x4 = scanner.nextDouble();
            double y4 = scanner.nextDouble();


            //点1至点2的距离
            double first1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            //点2至点3的距离
            double second = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

            //点3至点1的距离
            double third = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));

            //点4至点1的距离
            double forth = Math.sqrt((x4 - x1) * (x4 - x1) + (y4 - y1) * (y4 - y1));

            //点4至点3的距离
            double fifth = Math.sqrt((x4 - x3) * (x4 - x3) + (y4 - y3) * (y4 - y3));

            //计算四边形面积
            double s1 = (first1 + second + third) / 2;
            double area1 = Math.sqrt(s1 * (s1 - first1) * (s1 - second) * (s1 - third));

            double s2 = (forth + fifth + third) / 2;
            double area2 = Math.sqrt(s2 * (s2 - forth) * (s2 - fifth) * (s2 - third));

            double area = area1 + area2;

            System.out.println("area" + area);
        }
    }

    class Rectangle extends Quadrangle {
        @Override
        public void draw() {
            System.out.println("Rectangle");
            getArea();

        }


    }

    class Trapezoid extends Quadrangle {
        @Override
        public void draw() {
            System.out.println("Trapezoid");
            getArea();
        }
    }





