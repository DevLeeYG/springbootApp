package com.play.test.data.repository;

import com.play.test.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 엔티티가 생성한 데이터베이스에 접근하는데 사용
 * <Product : 대상 엔티티 , Long : 필드타입>
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

}
