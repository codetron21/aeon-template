package com.example.aeon.controller;

import com.example.aeon.dto.KaryawanDto;
import com.example.aeon.service.KaryawanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/karyawan")
public class KaryawanController {

  @Autowired
  private KaryawanService service;

  @PutMapping("/{karyawanId}")
  public ResponseEntity<Object> updateKaryawan(
      @PathVariable("karyawanId") Integer karyawanId,
      @RequestBody KaryawanDto dto
  ) {
    Integer id = service.updateKaryawan(dto, karyawanId);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");

    if (id == null) {
      response.put("message", "failed update data");
    } else {
      response.put("data", id);
    }

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{karyawanId}")
  public ResponseEntity<Object> deleteKaryawanById(
      @PathVariable("karyawanId") Integer karyawanId
  ) {
    Integer id = service.removeKaryawan(karyawanId);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");

    if (id == null) {
      response.put("message", "failed delete data");
    } else {
      response.put("message", "success delete data");
    }

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<Object> postKaryawan(
      @RequestBody KaryawanDto dto
  ) {
    KaryawanDto karyawan = service.createKaryawan(dto);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", karyawan);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/list")
  public ResponseEntity<Object> getAllKaryawan(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size,
      @RequestParam(value = "aktif", defaultValue = "true") Boolean aktif
  ) {
    List<KaryawanDto> listKaryawan = service.getAllKaryawan(page, size, aktif);

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", listKaryawan);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/{karyawanId}")
  public ResponseEntity<Object> getKaryawanById(
      @PathVariable("karyawanId") Integer karyawanId
  ) {
    KaryawanDto karyawan = service.findKaryawanById(karyawanId);
    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");

    if (karyawan == null) {
      response.put("message", "karyawan not exists");
    } else {
      response.put("data", karyawan);
    }

    return ResponseEntity.ok(response);
  }

}
