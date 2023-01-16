package com.play.test.data.dto;

public class ChangeProductStatusDto {

    private Long number;
    private String name;
    private Integer price;
    private Integer stock;

    public ChangeProductStatusDto(Long number, String name, Integer price, Integer stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getNumber() {
        return this.number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
