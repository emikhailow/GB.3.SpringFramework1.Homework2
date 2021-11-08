package ru.geekbrains.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.homework2");
        Cart cart = context.getBean(Cart.class);

        System.out.println("Use one of the followinga commands:");
        System.out.println("add {ID}, remove {ID}, list, exit");

        Scanner sc = new Scanner(System.in);
        while(true){
            String command = sc.nextLine();
            if(command.startsWith("add")){
                Long id = Long.valueOf(command.split("\\s+")[1]);
                Product product = cart.add(id);
                if(product != null) {
                    System.out.println(String.format("Item %s has been added", product.getName()));
                } else
                {
                    System.out.println(String.format("Item with ID %d not found", id));
                }
            } else if(command.startsWith("remove")){
                Long id = Long.valueOf(command.split("\\s+")[1]);
                Product product = cart.remove(id);
                if(product != null) {
                    System.out.println(String.format("Item %s has been removed", product.getName()));
                } else
                {
                    System.out.println(String.format("Item with ID %d not found", id));
                }
            } else if(command.startsWith("list")){
                Map<Product, Integer> shoppingList =  cart.getShoppingList();
                if(shoppingList.isEmpty()){
                    System.out.println("Shopping list is empty");
                }else
                {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<Product, Integer> entry : shoppingList.entrySet()) {
                        sb.append(String.format("%s (ID %d): %d\n",
                                entry.getKey().getName(),
                                entry.getKey().getId(),
                                entry.getValue()));
                    };
                    System.out.println(sb.toString());
                }
            } else if(command.startsWith("exit")){
                break;
            } else{
                System.out.println("Use one of the followin commands:");
                System.out.println("add {ID}, remove {ID}, list, exit");
            }
        }
    }
}