package com.metricsApi.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.service.MetricService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MetricsController.class)
public class MetricValuesControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MetricService service;
	
	Metrics metric;
	
	List<Metrics> metricsList = new ArrayList<>();
	
	String URI = "/api/v1/metrics";
	
	
	////////////////for reference only/////////////////////
	
					//	 id;
					//	 name;
					//	 created;
					//	 values;
	
	///////////////////////////////////////////////////////
	
	
	@Before
	public void init() {
		
		
		 metric = new Metrics();
		 metric.setId(1l);
		 metric.setName("speed");
		 metric.setCreated( new Date());
//		 metric.setValues(new MetricValues());		 
		 metricsList.add(metric);
		 
		when(service.findAll()).thenReturn(metricsList);
	}

	@Test
	public void test() throws Exception {
		
		mockMvc.perform(get("/api/v1/metrics")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
				
		
	}

}
