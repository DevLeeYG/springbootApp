package com.play.test.service.impl;


import com.play.test.data.dto.ProductDto;
import com.play.test.data.dto.ProductResponseDto;
import com.play.test.data.entity.Product;
import com.play.test.data.repository.ProductRepository;
import com.play.test.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number){
        LOGGER.info("[getProduct] input number : {}",number);
        Product product = productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number : {}, name :{}",product.getNumber(),product.getName());

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
        LOGGER.info("[saveProduct] productDTO : {}", productDto.toString());

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreateAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);


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
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
    productRepository.deleteById(number);
    }


}
