package com.metricsApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metricsApi.data.Metrics;
import com.metricsApi.service.MetricService;

@RestController
@RequestMapping(value = "/api/v1")
public class MetricsController {
	
	@Autowired
	private MetricService service;
	
	@GetMapping(value="/metrics")
	public List<Metrics> getAllMetrics() {
		return service.findAll();
	}
	
	@PostMapping(value="/metrics/add")
	public void insertMetric(@RequestBody Metrics metric) {
		service.insertMetric(metric);
		
	}

}
