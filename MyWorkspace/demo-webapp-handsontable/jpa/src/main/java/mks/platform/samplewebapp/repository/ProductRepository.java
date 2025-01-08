package mks.platform.samplewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mks.platform.samplewebapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
