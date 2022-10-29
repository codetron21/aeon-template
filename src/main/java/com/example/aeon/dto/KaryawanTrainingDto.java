package com.example.aeon.dto;

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
public class KaryawanTrainingDto extends BaseDto{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="tanggal_training")
  @Temporal(TemporalType.DATE)
  @JsonProperty(value="tanggal_training")
  private Date tanggalTraining;

  @ManyToOne
  @JoinColumn(name="karyawan_id")
  private KaryawanDto karyawan;

  @ManyToOne
  @JoinColumn(name="training_id")
  private TrainingDto trainingDto;

}
