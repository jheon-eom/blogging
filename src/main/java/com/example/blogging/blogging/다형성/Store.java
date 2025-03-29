package com.example.blogging.blogging.다형성;

import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public Product choiceProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
    }
}

