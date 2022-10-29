package com.example.aeon.repository;

import com.example.aeon.dto.KaryawanTrainingDto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepository extends
    PagingAndSortingRepository<KaryawanTrainingDto, Integer> {

}
