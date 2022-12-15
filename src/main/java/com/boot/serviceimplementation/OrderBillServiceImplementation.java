package com.boot.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.OrderBillEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.payload.OrderBillDTO;
import com.boot.repository.OrderBillRepository;
import com.boot.service.OrderBillService;

@Service
public class OrderBillServiceImplementation implements OrderBillService
{
 
	@Autowired
	private OrderBillRepository orderRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public OrderBillDTO addOrder(OrderBillDTO order) 
	{
		// TODO Auto-generated method stub
		OrderBillEntity orderEntity = this.modelMapper.map(order, OrderBillEntity.class);
		
		OrderBillEntity savedOrderEntity = this.orderRepository.save(orderEntity);
		
		
		return this.modelMapper.map(savedOrderEntity, OrderBillDTO.class);

	}

	@Override
	public List<OrderBillDTO> getAllOrderList() 
	{
		// TODO Auto-generated method stub
		List<OrderBillEntity> orderList =this.orderRepository.findAll();
		List<OrderBillDTO>  orderListDto = orderList.stream().map(order->this.modelMapper.map(order, OrderBillDTO.class))
				.collect(Collectors.toList());
		return orderListDto;
		
	}

	@Override
	public OrderBillDTO getOrderById(int orderId)
	{
		// TODO Auto-generated method stub
		OrderBillEntity orderObj = this.orderRepository
				.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("order","orderId",orderId));
				return this.modelMapper.map(orderObj, OrderBillDTO.class);
	}

	@Override
	public void deleteOrderById(int orderId)
	{
		// TODO Auto-generated method stub
		if(this.orderRepository.existsById(orderId)) 
		{
			this.orderRepository.deleteById(orderId);
			
		}
		else
		{
			throw new ResourceNotFoundException("Order","OrderId", orderId);
		}
		
	}

	@Override
	public OrderBillDTO updateOrderByID(OrderBillDTO order, int orderId) 
	{
		// TODO Auto-generated method stub
		if(this.orderRepository.existsById(orderId)) 
		{
			OrderBillEntity orderObj = this.modelMapper.map(order,OrderBillEntity.class);
			OrderBillEntity updatedOrder= this.orderRepository.save(orderObj);
			
			return this.modelMapper.map(updatedOrder, OrderBillDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Order","OrderId", orderId);
		}
	
	}

}
