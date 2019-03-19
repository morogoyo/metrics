package com.metricsApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metricsApi.data.Metrics;
import com.metricsApi.service.MetricService;

@RestController
@RequestMapping(value = "/")
public class MetricsController {
	
	@Autowired
	private MetricService service;
	
	@RequestMapping(value="metrics")
	public void getAllMetrics() {
		service.findAll();
	}
	
	@RequestMapping(value="/add/metric", method = RequestMethod.POST)
	public void insertMetric(@RequestParam Metrics metric) {
		service.insertMetric(metric);
		
	}

}
