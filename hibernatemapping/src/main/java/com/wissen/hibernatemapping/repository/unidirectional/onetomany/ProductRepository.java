package com.wissen.hibernatemapping.repository.unidirectional.onetomany;

import com.wissen.hibernatemapping.entity.unidirectional.onetomany.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
