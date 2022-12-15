package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.ItemEntity;


public interface ItemRepository extends JpaRepository<ItemEntity, Integer>
{

}
