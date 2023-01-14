package com.play.api.data.dao;

import com.play.api.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductStatus(Long number, String name, int price, int stock) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
