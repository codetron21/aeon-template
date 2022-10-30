package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "detail_karyawan")
@JsonInclude(Include.NON_NULL)
public class KaryawanDetailDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @JsonProperty("id")
  private Integer id;

  @Column(name = "nik", unique = true)
  @JsonProperty("nik")
  private String nik;

  @Column(name = "npwp", unique = true)
  @JsonProperty("npwp")
  private String npwp;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_karyawan", nullable = false)
  @JsonIgnore
  private KaryawanDto karyawan;

}
