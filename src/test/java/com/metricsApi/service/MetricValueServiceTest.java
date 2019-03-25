package com.metricsApi.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.springframework.data.geo.Metric;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.metricsApi.data.MetricValues;
import com.metricsApi.data.Metrics;
import com.metricsApi.repository.MetricRepository;
import com.metricsApi.repository.MetricValuesRepository;

import io.micrometer.core.instrument.Measurement;

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

	@Before
	public void initTest() {

		List<MetricValues> metricValuesinitList = new ArrayList<>();

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

		Metrics speed  = new Metrics(1l, "speed", new Date(), metricValuesinitList);
		Metrics height = new Metrics(2l, "height", new Date(), metricValuesinitList);
		Metrics weight = new Metrics(3l, "weight", new Date(), metricValuesinitList);

	

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
		Gson json = new Gson();
		String printMetric = json.toString();

//		Mockito.when(mvRepo.findByMetric_Id(1l)).thenReturn(metricsValuesOdd);

	}

}
