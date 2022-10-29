package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "karyawan")
public class KaryawanDto extends BaseDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @Column(name = "alamat")
  @JsonProperty("alamat")
  private String address;

  @Temporal(TemporalType.DATE)
  @Column(name = "dob")
  @JsonProperty("tanggal_lahir")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dob;

  @Column(name = "jk")
  @JsonProperty("jenis_kelamin")
  private String jk;

  @Column(name = "nama", nullable = false)
  @JsonProperty("nama")
  private String nama;

  @Column(name = "status")
  @JsonProperty("status")
  private String status;

  @OneToOne(mappedBy = "karyawan")
  @JsonProperty(value = "karyawan_detail")
  private KaryawanDetailDto karyawanDetail;

  @OneToMany(mappedBy = "karyawan")
  @JsonProperty(value = "list_rekening")
  private List<RekeningDto> rekening;

}
