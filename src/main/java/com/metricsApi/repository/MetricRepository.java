package com.metricsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metricsApi.data.Metrics;

public interface MetricRepository extends JpaRepository<Metrics, Long> {

}
