// Abstract class Shape
abstract class Shape {
    int dimension1, dimension2; 

    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public abstract void printArea();
}

class Rectangle extends Shape {

    public Rectangle(int length, int breadth) {
        super(length, breadth); 
    }

    @Override
    public void printArea() {
        int area = dimension1 * dimension2; 
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {

    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public void printArea() {
        double area = 0.5 * dimension1 * dimension2; 
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {

    public Circle(int radius) {
        super(radius, 0);  
    }

    @Override
    public void printArea() {
        double area = Math.PI * Math.pow(dimension1, 2); 
        System.out.println("Area of Circle: " + area);
    }
}

public class ShapeArea {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);
        Triangle triangle = new Triangle(8, 4);
        Circle circle = new Circle(7);

        rectangle.printArea();  
        triangle.printArea();  
        circle.printArea();    
    }
}
