package com.metricsApi.controllers;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.service.MetricService;
import com.metricsApi.service.MetricValueService;

@RestController
@RequestMapping(value = "/api/v1")
public class MetricValuesController {

	@Autowired
	private MetricService metricService;

	@Autowired
	private MetricValueService metricValueService;

	@GetMapping
	public List<MetricValues> getAll() {
		return metricValueService.findAll();

	}

	@PostMapping(value = "/metric_value")
	public void insertMetric(@RequestBody MetricValues mv) {

		try {
//			find metric to correlate
			Metrics metric = metricService.findByName(mv.getName());

//			edit object to be saved
			mv.setName(metric.getName());
			mv.getMetric().setName(metric.getName());
			mv.getMetric().setId(metric.getId());

			metricValueService.insertMetricValue(mv);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@GetMapping(value = "min/{metricName}")
	public Double CalculateMetricMin(@RequestParam String metricName) {
		return metricValueService.metricMinimumValue(metricName);
	}

	@GetMapping(value = "max/{metricName}")
	public Double CalculateMetricMax(@RequestParam String metricName) {
		return metricValueService.metricMaxValue(metricName);
	}

	@GetMapping(value = "median/{metricName}")
	public Double CalculateMetricMedian(@RequestParam String metricName) {
		return metricValueService.metricMedianValue(metricName);
	}

	@GetMapping(value = "mean/{metricName}")
	public OptionalDouble CalculateMetricMean(@RequestParam String metricName) {
		return metricValueService.metricMeanValue(metricName);
	}

}
