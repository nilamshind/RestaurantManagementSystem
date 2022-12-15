package com.boot.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderBillEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int orderId;
    
	@Column(nullable=false)
	@NotNull(message ="orderDate can not be empty")
    private LocalDate orderDate;
    
    @NotEmpty(message="customerName can not be empty")
	@Column(nullable = false)
	@Size(min=3,max=10,message ="customerName must be minimum 3 charachters and maximum 10")
    private String customerName;
    
    @Column(nullable=false)
    @NotNull(message ="customerContactNo can not be empty")
    @Size(min=10,max=10,message ="customerContactNo must be minimum 10 charachters and maximum 10")
    private String customerContactNo;

    
    @NotEmpty(message="discriptionOfOrder can not be empty")
	@Column(nullable = false)
	@Size(min=2,max=100,message ="discriptionOfOrder must be minimum 2 charachters and maximum 100")
    private String discriptionOfOrder;
    
    @Column(nullable=false)
	@NotNull(message ="totalBill can not be empty")
	@Min(message = "Minimum totalBill should be 1",value=1)
    @Max(message = "Maximum totalBill should be 10000",value=10000)
    private int totalBill;
    

    @JsonIgnore
	@OneToMany(mappedBy = "orderBill",cascade = CascadeType.ALL)
	private List<OrderItemReportEntity> orderItemReportList = new ArrayList<>();
    
 
}
