package com.codegym.controller;

import com.codegym.DAO.category.CategoryDAO;
import com.codegym.model.category.Category;
import com.codegym.model.products.Product;
import com.codegym.service.products.IProductService;
import com.codegym.service.products.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Module3Servlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.findCategoryList();
        request.setAttribute("categoryList",categoryList);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/update.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.findCategoryList();
        request.setAttribute("categoryList",categoryList);
        List<String> categoryNameList = categoryDAO.findCategoryNameList();
        request.setAttribute("categoryNameList",categoryNameList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        dispatcher.forward(request, response);
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int productId = Integer.parseInt(request.getParameter("productId"));
//        String categoryName = productService.findCategoryName(productId);
//        request.setAttribute("categoryName",categoryName);
        List<Product> productList = null;
        String search = request.getParameter("search");
        if (search == null || search.equals("")) {
            productList = productService.findAll();
        } else {
            productList = productService.findByName(search);
        }
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher;
        productService.delete(id);
        response.sendRedirect("/products");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.findCategoryList();
        request.setAttribute("categoryList",categoryList);
        int id = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(productName,price,amount,color,description,category);
        productService.update(id,product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products");
        dispatcher.forward(request,response);
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(productName,price,amount,color,description,category);
        productService.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        dispatcher.forward(request,response);
    }
}
