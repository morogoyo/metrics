package com.metricsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metricsApi.data.MetricValues;

@Repository
public interface MetricValuesRepository extends JpaRepository<MetricValues, Long> {

	@Query(value = "SELECT * FROM metric_value where metric_id = ?1",
			nativeQuery = true)
	List <MetricValues> findByMetric_Id(Long id);

}
