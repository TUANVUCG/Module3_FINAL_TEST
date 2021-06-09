package com.codegym.service.products;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.DAO.products.IProductDAO;
import com.codegym.DAO.products.ProductDAO;
import com.codegym.model.products.Product;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDAO productDAO = new ProductDAO();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDAO.update(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public int findCategoryIdByProductId(int productId) {
        return productDAO.findCategoryIdByProductId(productId);
    }

    @Override
    public String findCategoryName(int productId) {
        return productDAO.findCategoryName(productId);
    }
}
