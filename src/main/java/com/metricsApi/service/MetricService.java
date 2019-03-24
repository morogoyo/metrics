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

	public Metrics findByName(String name) {

		Metrics metrics = null;

		try {
			metrics = repo.findByName(name);

		} catch (Exception e) {
			System.out.println("Metric Name does not exist");
		}

		return metrics;

	}

	public void delete(String metricName) {

		try {
			Metrics metric = findByName(metricName);
//		toss up whether to delete by id or entity
			Long id = metric.getId();
			repo.deleteById(id);
		} catch (Exception e) {
			System.out.println("Metric Name does not exist  ");
			e.printStackTrace();
		}

	}

}
