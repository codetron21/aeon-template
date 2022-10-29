package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "training")
public class TrainingDto extends BaseDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nama_pengajar", nullable = false)
  @JsonProperty("nama_pengajar")
  private String namaPengajar;

  @Column(name = "tema", nullable = false)
  @JsonProperty("tema")
  private String tema;

}
