package com.example.blogging.blogging.다형성;

public class Counter {

    public static void calculate(Product product, Customer customer) {
        System.out.println("------------------------------------");
        System.out.println(customer.getGrade() + " 고객님의 계산을 시작합니다.");
        System.out.println(product.getName() + " 상품의 가격은 " + product.getPrice() + "원 입니다.");

        customer.getBenefit().use();

        System.out.println("계산을 종료합니다.");
        System.out.println("------------------------------------");
    }
}


