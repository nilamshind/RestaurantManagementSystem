package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class ItemEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int itemNo;
   
	@NotEmpty(message="item name can not be empty")
	@Column(nullable = false)
	@Size(min=3,max=10,message ="item name must be minimum 3 charachters and maximum 10")
    private String itemName;
   
	@Column(nullable=false)
	@NotNull(message ="itemPrice can not be empty")
	@Min(message = "Minimum itemPrice should be 20",value=10)
    @Max(message = "Maximum itemPrice should be 1000",value=1000)
    private int itemPrice;
   
	@NotEmpty(message="itemType can not be empty")
	@Column(nullable = false)
	@Size(min=3,max=20,message ="itemType must be minimum 3 charachters and maximum 20")
    private String itemType;
   
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId1")
	private CategoryEntity category;
		
	@JsonIgnore
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
	private List<OrderItemReportEntity> orderItemReportList = new ArrayList<>();

	
}
