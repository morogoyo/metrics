package com.metricsApi.service;

import java.util.List;
import java.util.stream.Stream;

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

		List<MetricValues> metricsList = null;
		try {
			Metrics metricObj = metricRepo.findByName(metricName);
			metricsList = metricValueRepo.findByMetric_Id(metricObj.getId());

		} catch (NullPointerException e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}
		return metricsList;
	}

	public Double metricMinimumValue(String metricName) {

		MetricValues min = null;

		try {
			List<MetricValues> minVal = findByMetric(metricName);

			min = minVal.stream().min((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();
		} catch (NullPointerException e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}

		return min.getValue();

	}

	public Double metricMaxValue(String metricName) {
		MetricValues max = null;

		try {
			List<MetricValues> maxVal = findByMetric(metricName);

			max = maxVal.stream().max((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();
		} catch (NullPointerException e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}

		return max.getValue();

	}

	public Double metricMedianValue(String metricName) {
		Double median = null;
		
			List<MetricValues> medianVal = null;
			try {
				medianVal = findByMetric(metricName);
			} catch (Exception e) {
				System.out.println("Metric was not found, please create metric and try again ");
				e.printStackTrace();
			}
			
			long size = medianVal.size();
			
			
			if(size%2 == 1) {
//				median = 
				
			}else {
				
				median = ( (double)(size+1)/2 + (double)(size)/2 ) / 2;
				}			

//			 median = medianVal.stream().sorted().limit(2 - size % 2).average().orElse(Double.NaN);

			return median;

	}

	public MetricValues metricMeanValue(String metricName) {

		try {
			List<MetricValues> meanVal = findByMetric(metricName);

		} catch (Exception e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}

		return null;

	}

}
