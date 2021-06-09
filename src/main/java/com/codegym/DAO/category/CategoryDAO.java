package com.codegym.DAO.category;

import com.codegym.DAO.SQLConnection;
import com.codegym.DAO.products.IProductDAO;
import com.codegym.DAO.products.ProductDAO;
import com.codegym.model.category.Category;
import com.codegym.model.products.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    IProductDAO productDAO = new ProductDAO();
    public static String SHOW_ALL_CATEGORY = "select * from category";
    public static String FIND_CATEGORY_NAME_BY_ID = "select category from category where id =?";
    public static String FIND_CATEGORY_NAME_LIST = "select category from category";

    public List<Category> findCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SHOW_ALL_CATEGORY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String category = resultSet.getString(2);
                categoryList.add(new Category(id, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<String> findCategoryNameList() {
        List<String> categoryNameList = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_CATEGORY_NAME_LIST);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                categoryNameList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryNameList;
    }

    public String getFindCategoryNameById(int id) {
        String categoryName = null;
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_CATEGORY_NAME_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                categoryName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryName;
    }


    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.findCategoryList();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}
