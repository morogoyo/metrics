package com.metricsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metricsApi.data.MetricValues;

@Repository
public interface MetricValuesRepository extends JpaRepository<MetricValues, Long> {

}
