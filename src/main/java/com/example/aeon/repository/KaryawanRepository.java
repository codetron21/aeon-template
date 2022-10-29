package com.example.aeon.repository;

import com.example.aeon.dto.KaryawanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<KaryawanDto, Integer> {

  @Query("SELECT k FROM KaryawanDto k WHERE k.deletedDate = NULL")
  Page<KaryawanDto> getAllAktifKaryawan(Pageable pageable);

}
