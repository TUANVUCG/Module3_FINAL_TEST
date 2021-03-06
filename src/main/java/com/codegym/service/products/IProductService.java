package com.codegym.service.products;

import com.codegym.model.products.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    boolean create(Product product);

    boolean update(int id, Product product);

    boolean delete(int id);

    List<Product> findByName(String name);

    int findCategoryIdByProductId(int productId);

    String findCategoryName(int productId);
}
