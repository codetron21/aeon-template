package com.example.aeon.controller;

import com.example.aeon.repository.KaryawanTrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/training-karyawan")
public class KaryawanTrainingController {

  @Autowired
  private KaryawanTrainingRepository repository;

}
