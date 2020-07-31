package com.example.ViewCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ViewCatalog.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
   
}
