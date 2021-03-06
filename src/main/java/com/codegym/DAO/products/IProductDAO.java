package com.codegym.DAO.products;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.model.products.Product;

public interface IProductDAO extends IGeneralDAO<Product> {
    int findCategoryIdByProductId(int productId);

    String findCategoryName(int productId);
}
