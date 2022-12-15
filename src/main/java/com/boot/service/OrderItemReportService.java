package com.boot.service;

import java.util.List;

import com.boot.payload.OrderItemReportDTO;


public interface OrderItemReportService 
{
	//To add new OrderItemReport
		public OrderItemReportDTO addOrderItemReport(OrderItemReportDTO orderItemReport);
		
		//Get all the OrderItemReport
		public List<OrderItemReportDTO> getAllOrderItemReport();
		
		//To add new OrderItemReport
		public OrderItemReportDTO getOrderItemReportById(int orderReportId);
		
		//Update OrderItemReport
		public OrderItemReportDTO updateOrderItemReport(OrderItemReportDTO orderItemReport);
		
		//delete OrderItemReportById
		public void deleteOrderItemReportById(int orderReportId);
		
}
