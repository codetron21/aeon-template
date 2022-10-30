package com.example.aeon.service;

import com.example.aeon.dto.KaryawanTrainingDto;
import com.example.aeon.repository.KaryawanTrainingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KaryawanTrainingService {

  @Autowired
  private KaryawanTrainingRepository repository;

  public KaryawanTrainingDto createKaryawanTraining(
      KaryawanTrainingDto dto
  ) {
    return repository.save(dto);
  }

  public List<KaryawanTrainingDto> getAllKaryawanTraining(
      Integer page,
      Integer size
  ) {
    Pageable paging = PageRequest.of(page, size);

    Page<KaryawanTrainingDto> pageKaryawanTraining =
        repository.findAll(paging);

    return pageKaryawanTraining.getContent();
  }

}
