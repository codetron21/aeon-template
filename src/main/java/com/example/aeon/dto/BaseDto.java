package com.example.aeon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties(
    value={"created_date","updated_date","deleted_date"},
    allowGetters = true
)
public abstract class BaseDto implements Serializable {

    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(value="created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(value="updated_date")
    private Date updatedDate;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(value="deleted_date")
    private Date deletedDate;
}