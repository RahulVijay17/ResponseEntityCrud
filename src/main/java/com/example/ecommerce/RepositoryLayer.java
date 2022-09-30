package com.example.ecommerce;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLayer extends JpaRepository<Employee,Integer> {

}
