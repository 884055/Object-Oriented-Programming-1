package it.unive.dais.po1.quadrilaterals;

public class Square extends Rectangle {

    public Square(int edge) {
        super(edge, edge);
    }

    public double getEdge() {
        return super.getEdge1();
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10);
        Square s = new Square(10);
        r.getPerimeter();
        s.getPerimeter();
        r.getArea();
        s.getArea();
    }

}
