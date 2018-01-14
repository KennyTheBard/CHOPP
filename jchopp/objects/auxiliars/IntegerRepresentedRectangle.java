package jchopp.objects.auxiliars;

public class IntegerRepresentedRectangle {
    /**
     * Generic rectangle shape class.
     */

    private int x, y, width, height;

    public IntegerRepresentedRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}