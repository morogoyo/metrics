package com.metricsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metricsApi.data.Metrics;
import com.metricsApi.repository.MetricRepository;

@Service
public class MetricService {

	@Autowired
	private MetricRepository repo;

	public List<Metrics> findAll() {

		return repo.findAll();

	}

	public void insertMetric(Metrics metric) {
		repo.save(metric);
		
	}
	
	

}
