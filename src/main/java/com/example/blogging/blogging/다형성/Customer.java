package com.example.blogging.blogging.다형성;

public class Customer {

    private String grade;

    private DiscountAmount discountAmount;

    public Customer(String grade, DiscountAmount discountAmount) {
        this.grade = grade;
        this.discountAmount = discountAmount;
    }

    public String getGrade() {
        return this.grade;
    }

    public DiscountAmount getDiscountAmount() {
        return this.discountAmount;
    }
}

