import java.util.Scanner;

public class Shapes {

        public static void main(String[] args) {

            Shape shape = new Triangle();
            Triangle triangle = (Triangle) shape;
            triangle.area();

            Shape shape1 = new Point();
            Point point = (Point) shape1;
            point.getDistance();


        }
        

}


    class Triangle extends Shape {


        public void area() {
            System.out.println("triangle coords:");
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


            //点1至点2的距离
            double first1 = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            //点2至点3的距离
            double second =  Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));

            //点3至点1的距离
            double third = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));

            //计算三角形面积
            double s = (first1+second+third)/2;
            double area = Math.sqrt(s*(s-first1)*(s-second)*(s-third));
            System.out.println("area"+area);

        }
    }

    class Point extends Shape{
        private double a, b;

        public void getDistance() {
            System.out.println("a,b coords:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入点a的坐标：");
            double a1 = scanner.nextDouble();
            double b1 = scanner.nextDouble();
            System.out.println("请输入点b的坐标：");
            double a2 = scanner.nextDouble();
            double b2 = scanner.nextDouble();

            double distance = Math.sqrt((a1-a2)*(a1-a2)+(b1-b2)*(b1-b2));
            System.out.println("distance"+distance);

        }
    }

    class Shape {
        private String name;
    }

