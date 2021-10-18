package it.unive.dais.po1.quadrilaterals;

abstract public class Polyhedron {
    private double[] edges;

    public double getPerimeter() {
        double perimeter = 0.0;
        for(int i = 0; i < edges.length; i++)
            perimeter += edges[i];
        return perimeter;
    }

    public abstract double getArea();

    public abstract Polyhedron addEdge(double edge);
}
