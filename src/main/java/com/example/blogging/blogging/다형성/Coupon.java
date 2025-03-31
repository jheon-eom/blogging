package com.example.blogging.blogging.다형성;

public class Coupon implements Benefit {

    @Override
    public void use() {
        System.out.println("쿠폰을 사용합니다.");
    }
}

