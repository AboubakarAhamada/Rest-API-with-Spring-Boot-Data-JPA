package com.example.productCrud.services;

import com.example.productCrud.entities.Product;
import com.example.productCrud.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        try {
            if(productRepository.existsById(id)){
                productRepository.deleteById(id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void updateProduct(Long id, Product product){
        Optional<Product> actualProduct = productRepository.findById(id);
        if(!actualProduct.isEmpty()){
            actualProduct.get().setName(product.getName());
            actualProduct.get().setPrice(product.getPrice());
            actualProduct.get().setOrders(product.getOrders());

            productRepository.save(actualProduct.get());
        }

    }
}
