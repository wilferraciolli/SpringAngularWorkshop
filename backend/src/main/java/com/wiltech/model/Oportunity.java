package com.wiltech.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * The type Oportunity bean ORM.
 */
@Entity
@Data
public class Oportunity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Size(max = 80)
  @Column(name = "nome_prospecto")
  private String prospectName;

  @NotEmpty
  @Size(max = 200)
  private String description;

  @Min(0)
  private BigDecimal value;

}
