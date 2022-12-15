package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.OrderItemReportEntity;

public interface OrderItemReportRepository extends JpaRepository<OrderItemReportEntity, Integer>
{

 
    @Query(value="select * from order_item_report oir where oir.ino=:itemNo",nativeQuery =true)
    List<OrderItemReportEntity> getAllOrderItemReportByItemNo(@Param("itemNo") int itemNo);
	
    @Query(value="select * from order_item_report oir where oir.oid=:orderId",nativeQuery =true)
    List<OrderItemReportEntity> getAllOrderItemReporByOrderId(@Param("orderId") int orderId);
	

}
