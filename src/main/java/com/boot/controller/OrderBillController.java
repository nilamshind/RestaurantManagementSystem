package com.boot.controller;

import java.time.LocalDate;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exceptions.ApiResponse;
import com.boot.payload.OrderBillDTO;
import com.boot.service.OrderBillService;

@RestController
@RequestMapping("/orderBill")
@CrossOrigin("*")
public class OrderBillController 
{
	@Autowired
	private OrderBillService orderService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	public ResponseEntity<OrderBillDTO> addOrderBill(@Valid @RequestBody OrderBillDTO order)
	{
		//ResponseEntity
	       LocalDate date=  LocalDate.now();
	       order.setOrderDate(date);
   
		OrderBillDTO addOrder = this.orderService.addOrder(order);
		
		return new ResponseEntity<OrderBillDTO>(addOrder,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")//end point to featch all Order record
	public ResponseEntity<List<OrderBillDTO>> getAllOrderBill()
	{
		List<OrderBillDTO> allOrderList = this.orderService.getAllOrderList();
		return new ResponseEntity<List<OrderBillDTO>>(allOrderList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderBillDTO> getOrderBillById(@PathVariable("orderId") int orderId)
	{
		OrderBillDTO orderObj = this.orderService.getOrderById(orderId);
		return new ResponseEntity<OrderBillDTO>(orderObj,HttpStatus.OK);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<OrderBillDTO> updateOrderById(@Valid @RequestBody OrderBillDTO order,@PathVariable("orderId") int orderId)
	{
		OrderBillDTO updatedOrder = this.orderService.updateOrderByID(order, orderId);
		return new ResponseEntity<OrderBillDTO>(updatedOrder,HttpStatus.OK);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<ApiResponse> deleteOrderBill(@PathVariable("orderId") int orderId)
	{
		this.orderService.deleteOrderById(orderId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("Order record deleted orderId "+orderId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);	
	}
	
	
}
