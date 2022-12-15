package com.boot.service;

import java.util.List;

import com.boot.payload.OrderBillDTO;

public interface OrderBillService 
{
	public OrderBillDTO addOrder(OrderBillDTO order);
	  
	  public List<OrderBillDTO> getAllOrderList();
	  
	  public OrderBillDTO getOrderById(int orderId);
	  
	  public void deleteOrderById(int orderId);
	  
	  public OrderBillDTO updateOrderByID(OrderBillDTO order, int orderId);
	  
	 
	  
}
