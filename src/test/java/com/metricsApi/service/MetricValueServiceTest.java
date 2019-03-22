package com.metricsApi.service;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.metricsApi.data.MetricValues;
import com.metricsApi.repository.MetricValuesRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricValueServiceTest {
	
	
	@Autowired
	private MetricValueService mvService;
	
	
	
	@Test
	public void test() {
		List<MetricValues> maxVal = mvService.findByMetric("speed");
		
		for(MetricValues v : maxVal) {
			System.out.println(v.getValue());
		}		
//		
		MetricValues max = maxVal.stream().max((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();
		System.out.println(max.getValue());
		
	}

}
