package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rekening")
public class RekeningDto extends BaseDto{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @Column(name="jenis",nullable = false)
  @JsonProperty("jenis")
  private String jenis;

  @Column(name="nama",nullable = false)
  @JsonProperty("nama")
  private String nama;

  @Column(name="nomor",nullable = false)
  @JsonProperty("nomor")
  private String nomor;

  @ManyToOne
  @JoinColumn(name="id_karyawan")
  private KaryawanDto karyawan;

}
