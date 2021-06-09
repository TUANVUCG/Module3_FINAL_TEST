package com.codegym.controller;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = null;
        String search = request.getParameter("search");
        if(search==null||search.equals("")){
            productList= productService.findAll();
        }
        else {
            productList= productService.findByName(search);
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
        switch (action){
            case "create":
                createNewProduct(request,response);
                break;
            case "update":
                update(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
    }
}
