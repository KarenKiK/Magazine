package ru.itpark.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.shop.domain.IPhone;
import ru.itpark.shop.service.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @RequestMapping
    public String frontpage(Model model) {
        model.addAttribute("products", service.getAll());
        return "index";
    }

    @GetMapping(params = "search")
    public String searchPage(@RequestParam String search, Model model) {
        model.addAttribute("products", service.search(search));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("product");
        return "add";
    }
    @GetMapping("/addphone")
    public String addPhone(){
        return "addphone";
    }
    @PostMapping("/addphone")
    public String addPhone(@RequestParam int price,
                           @RequestParam String name,
                           @RequestParam String color,
                           @RequestParam int memorySize,
                           @RequestParam String os,
                           @RequestParam String phoneModel) {
        service.addPhone(memorySize, price, name, color, os, phoneModel);
        return "redirect:/";
    }

    @GetMapping("/addshirt")
    public String addShirt(){
        return "addshirt";
    }
    @PostMapping("/addshirt")
    public String addShirt(@RequestParam int price,
                           @RequestParam String name,
                           @RequestParam String color,
                           @RequestParam int size) {
        service.addTShirt(price,name,color,size);
        return "redirect:/";
    }


}
