package ru.itpark.shop.service;


import org.springframework.stereotype.Service;
import ru.itpark.shop.domain.IPhone;
import ru.itpark.shop.domain.Product;
import ru.itpark.shop.domain.TShirt;
import ru.itpark.shop.repository.ProductRepository;

@Service

public class ProductService {
    private ProductRepository repository;
    private Product products = new Product();
    private int nextId = 1;


    public ProductService(ProductRepository repository) {

        this.repository = repository;
    }

    public void add(IPhone iPhone) {
        repository.add(iPhone);
        nextId++;
    }

    public void addPhone(int memorySize, int price, String name, String color, String os, String phoneModel) {
        IPhone iPhone = new IPhone(price, name, color, nextId, memorySize, os, phoneModel);
        repository.add(iPhone);
        nextId++;
    }

    public void addTShirt(int price, String name, String color, int size) {
        TShirt tShirt = new TShirt(price, name, color, nextId, size);
        repository.add(tShirt);
        nextId++;
    }

    public Product[] getAll() {
        return repository.getAll();
    }

    public Product getById(int id) {
        return repository.getById(id);
    }

    public Product[] search(String search) {
        Product[] result = new Product[10];
        Product[] all = repository.getAll();
        int nextIndex = 0;
        for (Product product : all) {
            if (product != null && product.getName().contains(search)) {
                result[nextIndex] = product;
                nextIndex++;
            }
        }
        return result;
    }

}
