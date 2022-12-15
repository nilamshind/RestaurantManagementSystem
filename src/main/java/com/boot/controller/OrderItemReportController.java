package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exceptions.ApiResponse;
import com.boot.payload.OrderItemReportDTO;
import com.boot.service.OrderItemReportService;


@RestController
@RequestMapping("/orderItemReport")
@CrossOrigin("*")
public class OrderItemReportController 
{
	 @Autowired 
     private OrderItemReportService orderItemReportService;
  
     @PostMapping("/")// end point to add new record
	 public ResponseEntity<OrderItemReportDTO> addOrderItemReport(@Valid @RequestBody OrderItemReportDTO orderItemReportDto)
	 {
		
    	 OrderItemReportDTO addedOrderItemReport = this.orderItemReportService.addOrderItemReport(orderItemReportDto);
		
		return new ResponseEntity<OrderItemReportDTO>(addedOrderItemReport,HttpStatus.CREATED);		
	}
	
     @GetMapping("/")
     public ResponseEntity<List<OrderItemReportDTO>> getAllOrderItemReport()
     {
    	 List<OrderItemReportDTO> orderItemReportList = this.orderItemReportService.getAllOrderItemReport();
    	 
    	 return new ResponseEntity<List<OrderItemReportDTO>>(orderItemReportList,HttpStatus.OK);
    	 
     }
	
     @GetMapping("/{orderReportId}")
 	public ResponseEntity<OrderItemReportDTO> getOrderItemReportById(@PathVariable("orderReportId") int orderReportId)
 	{
    	 OrderItemReportDTO  orderItemReport= this.orderItemReportService.getOrderItemReportById(orderReportId);
 		return new ResponseEntity< OrderItemReportDTO>(orderItemReport,HttpStatus.OK);
 	}
 	
 	@PutMapping("/{orderReportId}")
 	public ResponseEntity< OrderItemReportDTO> updateOrderItemReport(@Valid @RequestBody  OrderItemReportDTO  orderItemReportDto)
 	{
 		 OrderItemReportDTO updatedOrderItemReport = this.orderItemReportService.updateOrderItemReport(orderItemReportDto);
 		return new ResponseEntity<OrderItemReportDTO>(updatedOrderItemReport,HttpStatus.OK);
 	}

 	@DeleteMapping("/{orderReportId}")
 	public ResponseEntity<ApiResponse> deleteOrderItemReportById(@PathVariable("orderReportId") int orderReportId)
 	{
 		this.orderItemReportService.deleteOrderItemReportById(orderReportId);
 		
 		ApiResponse response = new ApiResponse();//Api is used to handle custom message 
 		
 		response.setMessage("OrderItemReport is deleted successfully with orderReportId :"    +    orderReportId);
 		response.setStatus(true);
 		
 		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
 		
 		
 	}
}
