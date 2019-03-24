package com.metricsApi.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.metricsApi.data.MetricValues;
import com.metricsApi.repository.MetricValuesRepository;

import io.micrometer.core.instrument.Measurement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricValueServiceTest {
	
	

	@Autowired
	private MetricValueService mvService;
	
	@MockBean
	private MetricValuesRepository mvRepo;
	
	@MockBean
	private MetricValues metricValues;
	
	@Before
	public void initTest() {
		List<Double> metricsValuesOdd = new ArrayList<>();		
		metricsValuesOdd.add(55.56);
		metricsValuesOdd.add(81.46);
		metricsValuesOdd.add(56.89);
		metricsValuesOdd.add(25.35);
		metricsValuesOdd.add(10.75);
		
		List<Double> metricsValuesEven = new ArrayList<>();		
		metricsValuesEven.add(55.56);
		metricsValuesEven.add(81.46);
		metricsValuesEven.add(56.89);
		metricsValuesEven.add(25.35);
		
	}
	

	@Test
	@Ignore
	public void test() {
		List<MetricValues> maxVal = mvService.findByMetric("speed");

		for (MetricValues v : maxVal) {
			System.out.println(v.getValue());
		}
//		
		MetricValues max = maxVal.stream().max((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();
		System.out.println(max.getValue());

	}

	@Test
	public void medianTest() {

		String speed = "speed";
		
		Mockito.when(mvRepo.findByMetric_Id(1l)).thenReturn(metricsValuesOdd);

	}

	

}
