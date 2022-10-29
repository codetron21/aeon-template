package com.example.aeon.service;

import com.example.aeon.dto.KaryawanDto;
import com.example.aeon.repository.KaryawanRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KaryawanService {

  @Autowired
  private KaryawanRepository repository;

  public Integer updateKaryawan(KaryawanDto dto, Integer id) {
    if (!repository.existsById(id)) {
      return null;
    }

    dto.setId(id);
    repository.save(dto);

    return id;
  }

  public Integer removeKaryawan(Integer id) {
    KaryawanDto karyawan = repository.findById(id).orElse(null);
    if (karyawan == null) {
      return null;
    }

    karyawan.setStatus("tidak aktif");
    karyawan.setDeletedDate(new Date());

    repository.save(karyawan);

    return id;
  }

  public List<KaryawanDto> getAllKaryawan(Integer page, Integer size, Boolean aktif) {
    Pageable paging = PageRequest.of(page, size);
    Page<KaryawanDto> pageKaryawan;

    if (aktif) {
      pageKaryawan = repository.getAllAktifKaryawan(paging);
    } else {
      pageKaryawan = repository.findAll(paging);
    }

    return pageKaryawan.getContent();
  }

  public KaryawanDto findKaryawanById(Integer id) {
    return repository.findById(id).orElse(null);
  }

  public KaryawanDto createKaryawan(KaryawanDto dto) {
    return repository.save(dto);
  }

}
