package ru.geekbrains.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository productRepository;
    private Map<Product, Integer> shoppingList;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    private void init(){
        shoppingList = new HashMap<>();
    }

    public Product add(Long id){
        Product product = productRepository.getItemById(id);
        if(product == null){
            return null;
        }
        shoppingList.put(product, shoppingList.getOrDefault(product, 0) + 1);
        return product;
    }

    public Product remove(Long id) {
        Product product = productRepository.getItemById(id);
        if(product == null){
            return null;
        }
        int itemsLeft = shoppingList.getOrDefault(product, 0);
        if(itemsLeft == 0){
            return null;
        }
        shoppingList.remove(product);

        return product;
    }

    public Map<Product, Integer> getShoppingList() {
        return shoppingList;
    }
}
