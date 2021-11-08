package ru.geekbrains.homework2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;
    private final int ITEMS_COUNT = 5;

    @PostConstruct
    private void init(){
        generateNProducts(ITEMS_COUNT);
    }

    private void generateNProducts(int n){
        productList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            productList.add(new Product((long) (i + 1)));
        }
    }

    public Product getItemById(Long id){
        return productList.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public List<Product> getProductList() {
        return productList;
    }
}



