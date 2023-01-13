package com.play.api.service.impl;


import com.play.api.data.dao.ProductDAO;
import com.play.api.data.dto.ProductDto;
import com.play.api.data.dto.ProductResponseDto;
import com.play.api.data.entity.Product;
import com.play.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number){
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public  ProductResponseDto saveProduct(ProductDto productDto){

        //product 는 어떻게 보면 Entity 지만 또하나의 dto 일수도 있겠다.

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreateAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);


        //반환된 savedProduct 객체로 responseDto 에 담아 response 반환

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;


    }

    @Override
    public ProductResponseDto changeProductStatus(Long number, String name, Integer price, Integer stock) throws Exception{
        Product changedProduct = productDAO.updateProductStatus(number,name,price,stock);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
    productDAO.deleteProduct(number);
    }


}
