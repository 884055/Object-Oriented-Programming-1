package it.unive.dais.po1.quadrilaterals;

public abstract class Pentagon extends Polyhedron {
    private final double edge1, edge2, edge3, edge4, edge5;

    protected Pentagon(double edge1, double edge2, double edge3, double edge4, double edge5) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
        this.edge4 = edge4;
        this.edge5 = edge5;
    }
    public double getPerimeter() {
        return edge1+edge2+edge3+edge4+edge5;
    }

    public abstract double getArea();
}
