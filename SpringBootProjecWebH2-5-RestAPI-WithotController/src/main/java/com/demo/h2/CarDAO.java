package com.demo.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "car" , path = "car")
public interface CarDAO extends JpaRepository<Car, Integer> {

}
