package ru.itpark.shop.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itpark.shop.repository.ProductRepository;

@NoArgsConstructor

@Getter
@Setter
public class TShirt extends Product {
    private int size;

    public TShirt(int price, String name, String color, int id, int size) {
        super(price, name, color, id);
        this.size = size;
    }

    public TShirt(int size) {
        this.size = size;
    }
}

