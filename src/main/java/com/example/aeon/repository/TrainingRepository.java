package com.example.aeon.repository;

import com.example.aeon.dto.TrainingDto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends PagingAndSortingRepository<TrainingDto, Integer> {


}
