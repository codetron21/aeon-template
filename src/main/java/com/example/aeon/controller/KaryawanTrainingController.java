package com.example.aeon.controller;

import com.example.aeon.dto.KaryawanTrainingDto;
import com.example.aeon.service.KaryawanTrainingService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/training-karyawan")
public class KaryawanTrainingController {

  @Autowired
  private KaryawanTrainingService service;

  @GetMapping("/list")
  public ResponseEntity<Object> getAllKarywanTraining(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size,
      @RequestParam(name = "nama-karyawan", required = false) String namaKaryawan,
      @RequestParam(name = "nama-trainer", required = false) String namaTrainer
  ) {
    List<KaryawanTrainingDto> data =
        service.getAllKaryawanTraining(page, size);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", data);

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<Object> postKaryawanTraining(
      @RequestBody KaryawanTrainingDto dto
  ) {
    KaryawanTrainingDto data = service.createKaryawanTraining(dto);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", data);

    return ResponseEntity.ok(response);
  }

}
