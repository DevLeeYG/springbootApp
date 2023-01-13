package com.play.api.service;

import com.play.api.data.dto.ProductDto;
import com.play.api.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductStatus(Long number, String name ,Integer price, Integer stock) throws Exception;



    void deleteProduct(Long number) throws Exception;


}
