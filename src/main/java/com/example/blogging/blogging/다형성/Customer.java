package com.example.blogging.blogging.다형성;

public class Customer {

    private String grade;

    private Benefit benefit;

    public Customer(String grade, Benefit benefit) {
        this.grade = grade;
        this.benefit = benefit;
    }

    public String getGrade() {
        return this.grade;
    }

    public Benefit getBenefit() {
        return this.benefit;
    }
}

