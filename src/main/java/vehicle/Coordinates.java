package vehicle;

import exceptions.InvalidCoordinatesException;

public class Coordinates {
    private double x;
    private int y;

    public Coordinates(double x, int y) throws InvalidCoordinatesException {

        if (x < -18){
            throw new InvalidCoordinatesException("Invalid x coordinate, try again");
        }

        if (y < -607){
            throw new InvalidCoordinatesException("Invalid y coordinates, try again");
        }

        this.setX(x);
        this.setY(y);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x +
                " y = " + y;
    }
}
