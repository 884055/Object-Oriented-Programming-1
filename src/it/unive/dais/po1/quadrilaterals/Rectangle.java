package it.unive.dais.po1.quadrilaterals;

public class Rectangle {
    int width, height;

    public Rectangle() {

    }
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return this.height * this.width;
    }
}
