package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class CategoryEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int categoryId;
   
	@Column(nullable=false)
    @NotEmpty(message ="categoryType can not be empty")
    @Size(min=5,max=10,message ="categoryType must be minimum 5 charachters and maximum 20")
    private String categoryType;
   
	@NotEmpty(message="category Discription can not be empty")
	@Column(nullable = false)
	@Size(min=5,max=100,message ="Category Discription must be minimum 5 charachters and maximum 100")
    private String categoryDiscription;
	
	@JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<ItemEntity> itemEntityList = new ArrayList<>();
    
}
