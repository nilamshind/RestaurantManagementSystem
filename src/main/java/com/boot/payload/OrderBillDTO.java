package com.boot.payload;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.boot.entity.OrderItemReportEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderBillDTO 
{
    private int orderId;
    
    private LocalDate orderDate;
    
    private String customerName;
    
    private String customerContactNo;
    
    private String discriptionOfOrder;
    
    private int totalBill;
    
    @JsonIgnore
    private List<OrderItemReportEntity> orderItemReportList = new ArrayList<>();
    
    
}
