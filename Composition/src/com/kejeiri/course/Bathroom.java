package com.kejeiri.course;

public class Bathroom {
    public Bathroom(int size) {
        this.size = size;
        this.bathtub = new Tub(15);
    }

    private int size;
    private Tub bathtub;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Tub getBathtub() {
        return bathtub;
    }

    public void setBathtub(Tub bathtub) {
        this.bathtub = bathtub;
    }
}
