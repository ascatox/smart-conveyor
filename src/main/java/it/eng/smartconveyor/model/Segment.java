package it.eng.smartconveyor.model;

/**
 * @author ascatox
 */
public class Segment {

    private int lenght;
    private int direction;
    private boolean movement;

    public Segment() {
    }

    public Segment(int lenght, int direction, boolean movement) {
        this.lenght = lenght;
        this.direction = direction;
        this.movement = movement;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMovement() {
        return movement;
    }

    public void setMovement(boolean movement) {
        this.movement = movement;
    }
}
