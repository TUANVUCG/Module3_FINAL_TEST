package com.codegym.DAO.products;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.DAO.SQLConnection;
import com.codegym.model.products.Product;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public static final String SHOW_LIST_PRODUCTS = "select * from products";
    public static final String FIND_PRODUCT_BY_ID = "select * from products where id = ?";
    public static final String CREATE_NEW_PRODUCT = "insert into products value (?,?,?,?,?,?,?)";
    public static final String DELETE_BY_ID = "delete from products where productId = ?";
    public static final String FIND_BY_NAME = "select * from products where productName like ?";
    public static final String UPDATE_BY_ID = "call updateById(?,?,?,?,?,?,?)";

    @Override
    public List findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SHOW_LIST_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int amount = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int category = resultSet.getInt(7);
                Product product = new Product(productId,productName,price,amount,color,description,category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
    Product product = null;
    Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int amount = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int category = resultSet.getInt(7);
                product = new Product(productId,productName,price,amount,color,description,category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        Connection connection = SQLConnection.getConnection();
        int rowInserted = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PRODUCT);
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setFloat(3,product.getPrice());
            ps.setInt(4,product.getAmount());
            ps.setString(5,product.getColor());
            ps.setString(6,product.getDescription());
            ps.setInt(7,product.getCategory());
            rowInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted!=0;
    }

    @Override
    public boolean update(int id, Product product) {
        Connection connection = SQLConnection.getConnection();
        int rowUpdate = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID);
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setFloat(3,product.getPrice());
            ps.setInt(4,product.getAmount());
            ps.setString(5,product.getColor());
            ps.setString(6,product.getDescription());
            ps.setInt(7,product.getCategory());
            rowUpdate = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate!=0;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = SQLConnection.getConnection();
        int rowDelete = 0;
        try {
            PreparedStatement ps =  connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1,id);
            rowDelete = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete!=0;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME);
            ps.setString(1,"%"+name+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int amount = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int category = resultSet.getInt(7);
                Product product = new Product(productId,productName,price,amount,color,description,category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
