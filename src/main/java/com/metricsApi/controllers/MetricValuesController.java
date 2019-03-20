package com.metricsApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping(value = "/metric_value")
	public void insertMetric(@RequestBody MetricValues mv) {

		Metrics metric = metricService.findByName(mv.getName());
		System.out.println(metric);
		if (metric != null) {
			mv.setName(metric.getName());
			metricValueService.insertMetricValue(mv);
		}else {
			System.out.println("Metric was not found, please create metric and try again ");
		}
		
		
		
		

	}

}
