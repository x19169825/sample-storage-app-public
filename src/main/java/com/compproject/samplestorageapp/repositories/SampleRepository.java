package com.compproject.samplestorageapp.repositories;

import com.compproject.samplestorageapp.model.samples.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {

}
