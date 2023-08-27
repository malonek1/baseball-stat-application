package com.baseball.BaseballAPI.payload;

public class Cat {
    private String fact;
    private int length;

    public Cat() {

    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
