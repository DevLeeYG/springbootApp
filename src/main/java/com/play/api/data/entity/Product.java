package com.play.api.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
/*
* 데이터베이스의 테이블과 구조를 생성하는데 사용
* */
@Entity
@Table(name = " product")
public class Product {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer stock;

    private  LocalDateTime createAt;

    private LocalDateTime updateAt;





}
