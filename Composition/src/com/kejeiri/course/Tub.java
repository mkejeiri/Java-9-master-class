package com.kejeiri.course;

public class Tub {
    public Tub(int size) {
        this.size = size;
        b = new Bubble();
        b.setColor("blue");
        b.setRadius(23);
    }

    private int size;
    private Bubble b;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Bubble getB() {
        return b;
    }

    public void setB(Bubble b) {
        this.b = b;
    }

    public String getBubbleColor(){
        return b.getColor();
    }
}
