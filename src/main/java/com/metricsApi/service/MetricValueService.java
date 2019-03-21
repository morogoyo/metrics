package com.metricsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.repository.MetricRepository;
import com.metricsApi.repository.MetricValuesRepository;

@Repository
public class MetricValueService {

	@Autowired
	private MetricValuesRepository metricValueRepo;

	@Autowired
	private MetricRepository metricRepo;

	public void insertMetricValue(MetricValues mv) {

		metricValueRepo.save(mv);
	}

	public List<MetricValues> findAll() {

		return metricValueRepo.findAll();
	}

	public List<MetricValues> findByMetric(String metricName) {

		Metrics metricObj = metricRepo.findByName(metricName);
		List<MetricValues> metricsList = metricValueRepo.findByMetric_Id(metricObj.getId());

		return metricsList;

	}

	public Double metricMinimumValue(String metricName) {
		
		List <MetricValues> minVal = findByMetric(metricName);
		
		
		
		minVal.stream().mapToDouble(m -> m).max();
		
		return null;

	}

	public Double metricMaxValue() {
		
		
		return null;

	}
	
	public Double metricMedianValue() {
		
		
		return null;
		
	}

}
