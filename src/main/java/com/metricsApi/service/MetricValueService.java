package com.metricsApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metricsApi.data.MetricValues;
import com.metricsApi.repository.MetricValuesRepository;


@Repository
public class MetricValueService {
	
	@Autowired
	private MetricValuesRepository metricValueRepository;
	
	public void insertMetricValue(MetricValues mv) {
		
		metricValueRepository.save(mv);
	}

}
