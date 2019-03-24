package com.metricsApi.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "metric_value")
public class MetricValues {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	@CreatedDate
	private Date createdDate;

	@Column
	private Double value;

	@ManyToOne
	@JoinColumn(name = "metric_id", nullable = false)
	private Metrics metric;

	public MetricValues() {

	}

	public MetricValues(Long id, String name, Date createdDate, Double value, Metrics metric) {

		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.value = value;
		this.setMetric(metric);
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Long getId() {
		return id;
	}

	public Metrics getMetric() {
		return metric;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMetric(Metrics metric) {
		this.metric = metric;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
