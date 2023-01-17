package com.play.test.data.dao.impl;

import com.play.test.data.dao.ProductDAO;
import com.play.test.data.entity.Product;
import com.play.test.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getReferenceById(number);
        return selectedProduct;
    }


    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }


    @Override
    public Product updateProductStatus(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setUpdateAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);

        } else {
            throw new Exception();
        }

        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {

    }
}
