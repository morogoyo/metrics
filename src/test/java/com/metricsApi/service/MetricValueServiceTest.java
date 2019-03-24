package com.metricsApi.service;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
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
	@Ignore
	public void test() {
		List<MetricValues> maxVal = mvService.findByMetric("speed");
		
		for(MetricValues v : maxVal) {
			System.out.println(v.getValue());
		}		
//		
		MetricValues max = maxVal.stream().max((d1, d2) -> Double.compare(d1.getValue(), d2.getValue())).get();
		System.out.println(max.getValue());
		
	}
	
	@Test
	public void medianTest() {
		
//		List<MetricValues> medianVal = mvService.findByMetric("speed");
		
//		int medianValSize = medianVal.size();
		
		int medianValSize = 3;
		System.out.println((medianValSize-1)/2);

		
//		for(MetricValues v : medianVal) {
//			
//			if(medianValSize%2 == 1) {
//				System.out.println((medianValSize-1)/2);
//			}
//			System.out.println(v.getValue());
//		}
		
		//List<Double> var = medianVal.stream().map(MetricValues::getValue).sorted().skip(medianVal.size()-1)limit(2-medianVal.size()%2).collect(Collectors.toList());
		
//		for(Double v : var) {
//			
//			System.out.println(v);
//		}
//		
	}

}
