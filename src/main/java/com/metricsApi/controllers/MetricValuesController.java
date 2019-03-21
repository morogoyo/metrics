package com.metricsApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public List<MetricValues> getAll(){
		return metricValueService.findAll();
		
	}
	
	

	@PostMapping(value = "/metric_value")
	public void insertMetric(@RequestBody MetricValues mv) {			
		
		try {
//			find metric to correlate
			Metrics metric = metricService.findByName(mv.getName());
			
//			create object to be saved
			mv.setName(metric.getName());
			mv.getMetric().setName(metric.getName());
			mv.getMetric().setId(metric.getId());
			
//			Gson jsonObj = new Gson();
//			System.out.println(jsonObj.toJson(metric));
//			System.out.println(jsonObj.toJson(mv));
			metricValueService.insertMetricValue(mv);
			 
			
		} catch (Exception e) {
			
			System.out.println("Metric was not found, please create metric and try again ");
			e.printStackTrace(); 
		}
		
			
			
		
			
		
		
		
		
		

	}

}
