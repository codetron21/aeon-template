package com.example.aeon.service;

import com.example.aeon.dto.TrainingDto;
import com.example.aeon.repository.TrainingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

  @Autowired
  private TrainingRepository repository;

  public Integer updateTraining(
      Integer id,
      TrainingDto dto
  ){
    boolean trainingExists = repository.existsById(id);
    if (!trainingExists) {
      return null;
    }

    dto.setId(id);
    repository.save(dto);

    return id;
  }

  public TrainingDto createTraining(
      TrainingDto dto
  ) {
    return repository.save(dto);
  }

  public TrainingDto findTrainingById(
      Integer id
  ) {
    return repository.findById(id).orElse(null);
  }

  public List<TrainingDto> getAllTraining(
      Integer page, Integer size
  ) {
    Pageable paging = PageRequest.of(page, size);
    Page<TrainingDto> pageTraining = repository.findAll(paging);
    return pageTraining.getContent();
  }

}
