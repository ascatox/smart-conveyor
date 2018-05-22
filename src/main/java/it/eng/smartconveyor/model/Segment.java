package it.eng.smartconveyor.model;

/**
 * @author ascatox
 */
public class Segment {

    private int lenght;
    private int direction;

    public Segment() {
        this.lenght = 20;
    }

    public Segment( int direction) {
        this.lenght = 20;
        this.direction = direction;
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





}
