package it.unive.dais.po1.quadrilaterals;

abstract public class Quadrilateral extends Polyhedron {
    public double getEdge1() {
        return edge1;
    }

    public double getEdge2() {
        return edge2;
    }

    public double getEdge3() {
        return edge3;
    }

    public double getEdge4() {
        return edge4;
    }

    private final double edge1, edge2, edge3, edge4;

    protected Quadrilateral(double edge1, double edge2, double edge3, double edge4) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
        this.edge4 = edge4;
    }

    abstract public double getArea();

    public double getPerimeter() {
        return edge1+edge2+edge3+edge4;
    }

    /*public Polyhedron addEdge(double edge) {
        return new Pentagon(this.getEdge1(), this.getEdge2(), this.getEdge3(), this.getEdge4(), edge);
    }*/

}
