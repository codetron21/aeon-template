package com.example.aeon.controller;

import com.example.aeon.dto.TrainingDto;
import com.example.aeon.service.TrainingService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/training")
public class TrainingController {

  @Autowired
  private TrainingService service;

  @PostMapping
  public ResponseEntity<Object> postTraining(
      @RequestBody TrainingDto dto
  ) {
    TrainingDto trainingDto = service.createTraining(dto);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", trainingDto);

    return ResponseEntity.ok(response);
  }

  @PutMapping("{trainingId}")
  public ResponseEntity<Object> putTrainingById(
      @PathVariable("trainingId") Integer trainingId,
      @RequestBody TrainingDto dto
  ) {
    Integer id = service.updateTraining(trainingId, dto);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");

    if (id == null) {
      response.put("message", "Failed to update data");
    } else {
      response.put("data", id);
    }

    return ResponseEntity.ok(response);
  }

  @GetMapping("/list")
  private ResponseEntity<Object> getAllTraining(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size
  ) {
    List<TrainingDto> listTraining = service.getAllTraining(page, size);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", listTraining);

    return ResponseEntity.ok(response);
  }

  @GetMapping("{trainingId}")
  private ResponseEntity<Object> getTrainingById(
      @PathVariable("trainingId") Integer trainingId
  ) {
    TrainingDto trainingDto = service.findTrainingById(trainingId);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");

    if (trainingDto == null) {
      response.put("message", "Failed to get data");
    } else {
      response.put("data", trainingDto);
    }

    return ResponseEntity.ok(response);
  }

}
