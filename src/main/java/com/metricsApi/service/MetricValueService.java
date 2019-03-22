package com.metricsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.repository.MetricRepository;
import com.metricsApi.repository.MetricValuesRepository;

@Service
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

	public MetricValues metricMinimumValue(String metricName) {

		List<MetricValues> minVal = findByMetric(metricName);

		MetricValues min = minVal.stream().min((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();

		return min;

	}

	public MetricValues metricMaxValue(String metricName) {

		List<MetricValues> maxVal = findByMetric(metricName);

		MetricValues max = maxVal.stream().max((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();

		return max;

	}

	public MetricValues metricMedianValue(String metricName) {
		
		List<MetricValues> maxVal = findByMetric(metricName); 

		return null;

	}

}
