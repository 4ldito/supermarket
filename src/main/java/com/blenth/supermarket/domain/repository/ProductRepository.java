package com.blenth.supermarket.domain.repository;

import com.blenth.supermarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getProduct(int productId);
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional<List<Product>> getLessPrice(double precio);
    Product save(Product product);
    void delete(int productId);
}
