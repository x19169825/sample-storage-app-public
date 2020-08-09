package com.compproject.samplestorageapp.service;

import com.compproject.samplestorageapp.model.samples.Sample;
import com.compproject.samplestorageapp.repositories.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService  {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository){
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> listAll(){
        return sampleRepository.findAll();
    }

}
