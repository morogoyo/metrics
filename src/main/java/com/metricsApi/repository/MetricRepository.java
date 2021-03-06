package com.metricsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metricsApi.data.Metrics;

@Repository
public interface MetricRepository extends JpaRepository<Metrics, Long> {

	Metrics findByName(String name);

}
