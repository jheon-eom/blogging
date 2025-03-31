package com.example.blogging.blogging.다형성;

public class DiscountAmount implements Benefit {

    @Override
    public void use() {
        System.out.println("할인금액을 사용합니다.");
    }
}


