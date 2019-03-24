package com.metricsApi.service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
			System.out.println(medianVal);
		} catch (Exception e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}

//		size of list
		int size = medianVal.size();

		if (size <= 0) {
			return 0.0;
		}

//		Middle of list count
		int middle = ((size - 1) / 2);

		if (size == 1) {
			return medianVal.get(0).getValue();
		} else if (size <= 2) {
			return (medianVal.get(0).getValue() + medianVal.get(1).getValue()) / 2;
		} else if (size % 2 == 1) {
			median = medianVal.get(middle).getValue();
		} else {

			median = (medianVal.get(middle).getValue() + medianVal.get(middle + 1).getValue()) / 2;
		}

		return median;

	}

	public OptionalDouble metricMeanValue(String metricName) {
		OptionalDouble mean = null;
		try {
			List<MetricValues> meanVal = findByMetric(metricName);

			List<Double> meanList = meanVal.stream().map(mv -> mv.getValue()).collect(Collectors.toList());

			mean = (meanList.stream().mapToDouble(mv -> mv)).average();

		} catch (Exception e) {
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace();
		}

		return mean;

	}

}
