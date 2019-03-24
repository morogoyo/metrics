package com.metricsApi.service;

import java.lang.reflect.Array;
import java.util.Arrays;
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

import io.micrometer.core.instrument.Measurement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricValueServiceTest {

	@Autowired
	private MetricValueService mvService;

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

//		List<MetricValues> medianVal = mvService.findByMetric("speed");

//		int medianValSize = medianVal.size();

		Double[] arr = new Double[] { 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0 };
		List<Double> medianVal = Arrays.asList(arr);
		int medianValSize = medianVal.size();
		
		int middle = ((medianValSize - 1) / 2);
		// using these VVVVVVVVVVVVVVVVV
		System.out.println(medianVal.get(middle));
		System.out.println(medianVal.get(middle +1));
		System.out.println(middle);
		System.out.println(middle +1);
		
		double posFromLast = medianVal.get(((medianValSize-1) - ((medianValSize - 1) / 2)));

		System.out.println(medianVal.get(((medianValSize-1) - ((medianValSize - 1) / 2))));

		System.out.println((medianVal.get((medianValSize - 1) / 2)));

		double median = ((double) (medianValSize + 1) / 2 + (double) (medianValSize) / 2) / 2;

//		medianVal.get(index)

		System.out.println(median);

//		for(MetricValues v : medianVal) {
//			
//			if(medianValSize%2 == 1) {
//				
		System.out.println((medianValSize - 1) / 2);
//			}
//			System.out.println(v.getValue());
//		}

		// List<Double> var =
		// medianVal.stream().map(MetricValues::getValue).sorted().skip(medianVal.size()-1)limit(2-medianVal.size()%2).collect(Collectors.toList());

//		for(Double v : var) {
//			
//			System.out.println(v);
//		}
//		
	}

}
