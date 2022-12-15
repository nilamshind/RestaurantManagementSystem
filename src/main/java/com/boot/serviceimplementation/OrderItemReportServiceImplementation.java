package com.boot.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.OrderItemReportEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.payload.OrderItemReportDTO;
import com.boot.repository.OrderItemReportRepository;
import com.boot.service.OrderItemReportService;

@Service
public class OrderItemReportServiceImplementation implements OrderItemReportService 
{

	@Autowired
	private OrderItemReportRepository orderItemReportRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public OrderItemReportDTO addOrderItemReport(OrderItemReportDTO orderItemReport) 
	{
		// TODO Auto-generated method stub
		OrderItemReportEntity orderItemReportEntity = this.modelMapper.map(orderItemReport,OrderItemReportEntity.class);
		OrderItemReportEntity savedOrderItemReport = this.orderItemReportRepository.save(orderItemReportEntity); 	

		return this.modelMapper.map(savedOrderItemReport, OrderItemReportDTO.class);
	}

	@Override
	public List<OrderItemReportDTO> getAllOrderItemReport() 
	{
		// TODO Auto-generated method stub
		List<OrderItemReportEntity> orderItemReportList =this.orderItemReportRepository.findAll();
		List<OrderItemReportDTO>  orderItemReportDTOList = orderItemReportList.stream().map(orderItemReport->this.modelMapper.map(orderItemReport, OrderItemReportDTO.class))
				.collect(Collectors.toList());
		return orderItemReportDTOList;
	}

	@Override
	public OrderItemReportDTO getOrderItemReportById(int orderReportId)
	{
		// TODO Auto-generated method stub
		OrderItemReportEntity orderItemReportObj = this.orderItemReportRepository
				.findById(orderReportId).orElseThrow(()-> new ResourceNotFoundException("OrderItemReport","orderReportId",orderReportId));
				return this.modelMapper.map(orderItemReportObj, OrderItemReportDTO.class);
	}

	@Override
	public OrderItemReportDTO updateOrderItemReport(OrderItemReportDTO orderItemReport) 
	{
		// TODO Auto-generated method stub
		if(this.orderItemReportRepository.existsById(orderItemReport.getOrderReportId()))
		{
			OrderItemReportEntity orderItemReportObj = this.modelMapper.map(orderItemReport,OrderItemReportEntity.class);
			OrderItemReportEntity updatedOrderItemReport= this.orderItemReportRepository.save(orderItemReportObj);
			
			return this.modelMapper.map(updatedOrderItemReport, OrderItemReportDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("orderItemReport","orderReportId", orderItemReport.getOrderReportId());
		}
	}

	@Override
	public void deleteOrderItemReportById(int orderReportId) 
	{
		// TODO Auto-generated method stub
		if(this.orderItemReportRepository.existsById(orderReportId)) 
		{
			this.orderItemReportRepository.deleteById(orderReportId);
			
		}
		else
		{
			throw new ResourceNotFoundException("orderItemReport","orderReportId", orderReportId);
		}
		
	}

}
