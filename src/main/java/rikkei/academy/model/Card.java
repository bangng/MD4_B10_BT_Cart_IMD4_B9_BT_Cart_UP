package rikkei.academy.model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private Map<Product,Integer> products = new HashMap<>();

    public Card() {
    }

    public Card(Map<Product,Integer > products) {
        this.products = products;
    }

    public Map <Product,Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<  Product,Integer> products) {
        this.products = products;
    }
    private boolean checkItemInCard(Product product){
        for (Map.Entry<Product,Integer> entry:
             products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
    private Map<Product,Integer> selectItemInCard(Product product ){
        for (Map.Entry<Product,Integer> entry:
             products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())){
                return (Map<Product, Integer>) entry;
            }

        }
        return null;
    }
    public void addProduct(Product product){
        if (!checkItemInCard(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry = (Map.Entry<Product, Integer>) selectItemInCard(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void removeProduct(Product product){
        if (!checkItemInCard(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry = (Map.Entry<Product, Integer>) selectItemInCard(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            if (itemEntry.getValue() == 0){
                newQuantity = 0;
            }
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry:
             products.entrySet()) {
            productQuantity += entry.getValue();

        }
        return productQuantity;
    }
    public Integer countItemQuantity(){
        return products.size();
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product,Integer> entry:
             products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
