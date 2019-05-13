package ru.itpark.shop.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.shop.domain.Product;
@Repository
public class ProductRepository {
    private Product[] products = new Product[100];
    private int nextIndex = 0;

    public Product[] getAll() {
        return products;
    }

    public void add(Product product) {
        products[nextIndex]=product;
        nextIndex++;
    }

    public Product getById(int id){
        for (Product product : products) {
            if(product!=null&&product.getId()==id){
                return product;
            }
        }
        return null;
    }




}
