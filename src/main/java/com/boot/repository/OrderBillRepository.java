package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.OrderBillEntity;


public interface OrderBillRepository extends JpaRepository<OrderBillEntity, Integer>
{

}
