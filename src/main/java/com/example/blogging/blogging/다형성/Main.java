package com.example.blogging.blogging.다형성;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Store store = createStoreWithProducts();

        Customer basicCustomer = new Customer("BASIC", new None());
        Customer vipCustomer = new Customer("VIP", new DiscountAmount());
        Customer goldCustomer = new Customer("GOLD", new Coupon());
        Customer platinumCustomer = new Customer("PLATINUM", new Gift());

        Counter.calculate(store.choiceProduct("컴퓨터"), basicCustomer);
        Counter.calculate(store.choiceProduct("냉장고"), vipCustomer);
        Counter.calculate(store.choiceProduct("TV"), goldCustomer);
        Counter.calculate(store.choiceProduct("에어컨"), platinumCustomer);
    }

    private static Store createStoreWithProducts() {
        List<Product> addProducts = new ArrayList<>();
        addProducts.add(new Product("컴퓨터", 1000));
        addProducts.add(new Product("냉장고", 2000));
        addProducts.add(new Product("TV", 3000));
        addProducts.add(new Product("에어컨", 4000));
        Store store = new Store(addProducts);
        return store;
    }
}

