package com.example.productCrud.controllers;

import com.example.productCrud.entities.Product;
import com.example.productCrud.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products/{id}")
    public Optional<Product> getProducts(@PathVariable Long id){
        return productService.getProduct(id);
    }
    @GetMapping("products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("products/search")
    public List<Product> seachByName(@RequestParam String keyword){
        return productService.searchByName(keyword);
    }

    @PostMapping("products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("products/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }
}
