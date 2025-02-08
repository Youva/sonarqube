public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height cannot be negative.");
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(0.0, 0.0);
    }

    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        } else {
            System.err.println("Width cannot be negative.");
        }
    }

    public void setHeight(double height) {
        if (height >= 0) {
            this.height = height;
        } else {
            System.err.println("Height cannot be negative.");
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;

    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
