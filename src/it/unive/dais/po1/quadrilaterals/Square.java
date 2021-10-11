package it.unive.dais.po1.quadrilaterals;

public class Square extends Rectangle {

    public Square(int edge) {
        this.width = edge;
        this.height = edge;
    }

    public static void main(String[] args) {
        Square square = new Square(10);
        int area = square.getArea();
    }
}
