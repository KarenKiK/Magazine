package ru.itpark.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class IPhone extends Product{
    private int memorySize;
    private String os;
    private String phoneModel;

    public IPhone(int price, String name, String color, int id, int memorySize, String os, String phoneModel) {
        super(price, name, color, id);
        this.memorySize = memorySize;
        this.os = os;
        this.phoneModel = phoneModel;
    }

    public IPhone(int memorySize, String os, String model) {
        this.memorySize = memorySize;
        this.os = os;
        this.phoneModel = model;
    }
}
