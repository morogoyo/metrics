package com.metricsApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.metricsApi.service.MetricService;

@RestController
public class MetricsController {
	
	@Autowired
	private MetricService service;
	
	public void getAllMetrics() {
		
	}

}
