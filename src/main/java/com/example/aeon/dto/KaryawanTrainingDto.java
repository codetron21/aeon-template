package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "karyawan_training")
@JsonInclude(Include.NON_NULL)
public class KaryawanTrainingDto extends BaseDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "tanggal_training")
  @Temporal(TemporalType.DATE)
  @JsonProperty(value = "tanggal_training")
  @JsonFormat(timezone = "Asia/Jakarta")
  private Date tanggalTraining;

  @ManyToOne
  @JoinColumn(name = "karyawan_id")
  @JsonProperty(value = "karyawan")
  private KaryawanDto karyawan;

  @ManyToOne
  @JoinColumn(name = "training_id")
  @JsonProperty(value = "training")
  private TrainingDto training;

}
