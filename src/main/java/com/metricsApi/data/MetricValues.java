package com.metricsApi.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;



@Entity
@Table(name = "metric_value")
public class MetricValues {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column
	private Double value;
	


	public MetricValues(Long id, String name, Date createdDate, Double value, Metrics metric) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.value = value;

	}

	public MetricValues() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}


	
	
	

}
