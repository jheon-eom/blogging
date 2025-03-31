package com.example.blogging.blogging.다형성;

public class Gift implements Benefit {

    @Override
    public void use() {
        System.out.println("사은품을 증정합니다.");
    }
}

