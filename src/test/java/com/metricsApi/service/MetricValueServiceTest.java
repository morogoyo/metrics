package com.metricsApi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.repository.MetricRepository;
import com.metricsApi.repository.MetricValuesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricValueServiceTest {

	@Autowired
	private MetricValueService mvService;

	@Autowired
	private MetricRepository metricRepo;

	@MockBean
	private MetricValuesRepository mvRepo;

	@MockBean
	private MetricValues metricValues;

	
	Metrics speedObj;
	Metrics heightObj;
	Metrics weightObj;
	List<MetricValues> metricsValuesEven = new ArrayList<>();
	List<MetricValues> metricsValuesOdd = new ArrayList<>();
	List<MetricValues> metricValuesinitList = new ArrayList<>();

	
	
	@Before
	public void initTest() {

//		Long id, String name, Date createdDate, Double value, Metrics metric

		MetricValues speed  = new MetricValues(1l, "speed", new Date(), 55.56, new Metrics());
		MetricValues speed1 = new MetricValues(2l, "speed", new Date(), 81.46, new Metrics());
		MetricValues speed2 = new MetricValues(3l, "speed", new Date(), 56.89, new Metrics());
		MetricValues speed3 = new MetricValues(4l, "speed", new Date(), 25.35, new Metrics());
		MetricValues speed4 = new MetricValues(5l, "speed", new Date(), 10.75, new Metrics());
		MetricValues speed5 = new MetricValues(5l, "speed", new Date(), 17.33, new Metrics());

		MetricValues height  = new MetricValues(1l, "height", new Date(), 55.56, new Metrics());
		MetricValues height1 = new MetricValues(2l, "height", new Date(), 81.46, new Metrics());
		MetricValues height2 = new MetricValues(3l, "height", new Date(), 56.89, new Metrics());
		MetricValues height3 = new MetricValues(4l, "height", new Date(), 25.35, new Metrics());
		MetricValues height4 = new MetricValues(5l, "height", new Date(), 10.75, new Metrics());
		MetricValues height5 = new MetricValues(5l, "height", new Date(), 17.33, new Metrics());

//		List<MetricValues> metricValuesinitList = new ArrayList<>();

//		List<MetricValues> metricsValuesEven = new ArrayList<>();
		metricsValuesEven.add(speed);
		metricsValuesEven.add(speed1);
		metricsValuesEven.add(speed2);
		metricsValuesEven.add(speed3);
		metricsValuesEven.add(speed4);
		metricsValuesEven.add(speed5);

//		List<MetricValues> metricsValuesOdd = new ArrayList<>();

		metricsValuesEven.add(height);
		metricsValuesEven.add(height1);
		metricsValuesEven.add(height2);
		metricsValuesEven.add(height3);
		metricsValuesEven.add(height4);

		Metrics speedObj  = new Metrics(1l , "speed"  ,  new Date(), metricsValuesEven);
		Metrics heightObj = new Metrics(2l , "height" , new Date(), metricsValuesEven);
		Metrics weightObj = new Metrics(3l , "weight" , new Date(), metricValuesinitList);

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

		Metrics metric = metricRepo.findByName(speed);
		

		Mockito.when(mvRepo.findByMetric_Id(1l)).thenReturn(metricsValuesEven);

	}

}
