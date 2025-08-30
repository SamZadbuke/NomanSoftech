package com.nomansoftech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nomansoftech.entities.CustomerOrder;
import com.nomansoftech.entities.OrderItem;
import com.nomansoftech.entities.ProductCategory;
import com.nomansoftech.entities.ProductSubCategory;
import com.nomansoftech.entities.User;
import com.nomansoftech.entities.UserOrder;
import com.nomansoftech.models.ProductSummary;
import com.nomansoftech.repository.ProductCategoryRepository;
import com.nomansoftech.repository.ProductSubCategoryRepository;
import com.nomansoftech.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductSubCategoryRepository productSubCategoryRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public Integer deleteUser(Integer id) {
        try  {
            userRepository.deleteById(id);
            return id;
        } catch (EmptyResultDataAccessException ex) {
            // If the user was not found, return null or a specific value.
            return null ;
        }
    }

    // Orders
    public List<UserOrder> getAllOrders(int userId) {
        return userRepository.findAllOrders(userId);
    }

    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        return userRepository.findOrderItemsByOrderId(orderId);
    }

    public boolean updateOrderStatus(int orderId, String status) {
        return userRepository.updateOrderStatus(orderId, status) > 0;
    }

    // Product Categories
    public List<ProductCategory> fetchAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public List<ProductSubCategory> fetchAllProductSubCategories() {
        return productSubCategoryRepository.findAll();
    }

    public boolean updateProductSubCategoryPrice(int subCategoryId, float newPrice) {
        ProductSubCategory subCategory = productSubCategoryRepository.findById(subCategoryId).orElse(null);
        if (subCategory != null) {
            subCategory.setPrice(newPrice);
            productSubCategoryRepository.save(subCategory);
            return true;
        } else {
            return false;
        }
    }

    public ProductCategory addProductCategory(ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    public ProductSubCategory addProductSubCategory(ProductSubCategory subCategory, int categoryId) {
        ProductCategory category = productCategoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            subCategory.setCategory(category);  // ✅ Correct
            return productSubCategoryRepository.save(subCategory);
        }
        return null;  // Category not found
    }



    public boolean deleteProductCategory(Integer categoryId) {
        if (productCategoryRepository.existsById(categoryId)) {
            productCategoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }

    public boolean deleteProductSubCategory(Integer subCategoryId) {
        if (productSubCategoryRepository.existsById(subCategoryId)) {
            productSubCategoryRepository.deleteById(subCategoryId);
            return true;
        }
        return false;
    }

    // Recycling Summary
//    public List<ProductSummary> getMonthlySummary(int userId) {
//        return userRepository.findMonthlyByUserId(userId);
//    }
//
//    public List<ProductSummary> getYearlySummary(int userId) {
//        return userRepository.findYearlyByUserId(userId);
//    }
//
//    public List<ProductSummary> getYearlySummaryForAll() {
//        return userRepository.findYearlyForAll();
//    }
//
//    public List<ProductSummary> getMonthlySummaryForAll() {
//        return userRepository.findMonthlyForAll();
//    }
}

    
    
    
    
