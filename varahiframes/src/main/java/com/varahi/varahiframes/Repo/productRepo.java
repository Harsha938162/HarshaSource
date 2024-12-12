package com.varahi.varahiframes.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varahi.varahiframes.Model.Products;

public interface productRepo extends JpaRepository<Products,Integer>{

}
