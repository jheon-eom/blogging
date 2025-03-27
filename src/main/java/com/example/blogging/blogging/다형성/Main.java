package com.example.blogging.blogging.다형성;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> addProducts = new ArrayList<>();
        addProducts.add(new Product("컴퓨터", 1000));
        addProducts.add(new Product("냉장고", 2000));
        addProducts.add(new Product("TV", 3000));

        Store store = new Store(addProducts);

        Customer basicCustomer = new Customer("BASIC", null);
        Customer vipCustomer = new Customer("VIP", new DiscountAmount());

        Counter counter = new Counter();
        counter.calculate(store.choiceProduct("컴퓨터"), basicCustomer);
        counter.calculate(store.choiceProduct("냉장고"), vipCustomer);
    }
}
