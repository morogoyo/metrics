package com.metricsApi.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "metric")
public class Metrics {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column
	private String name;
	
	
	@Column
	@CreatedDate
	private Date created;

	@OneToMany( cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name = "metricId", referencedColumnName = "id")
	private List<MetricValues> values = new ArrayList<>();

	public Metrics(Long id, String name, Date created, List<MetricValues> values) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.values = values;
	}

	public Metrics() {
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<MetricValues> getValues() {
		return values;
	}

	public void setValues(List<MetricValues> values) {
		this.values = values;
	}	

}
