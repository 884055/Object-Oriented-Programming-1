package it.unive.dais.po1.quadrilaterals;

public class Rectangle extends Quadrilateral {

    public Rectangle(int width, int height) {
        super(width, width, height, height);
    }

    public double getHeight() {
        return super.getEdge3();
    }

    public double getWidth() {
        return super.getEdge1();
    }

    public double getArea() {
        return this.getHeight() * this.getWidth();
    }

    @Override
    public Polyhedron addEdge(double edge) {
        return null;
    }
}
