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
@Data
@Entity
public class Oportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 80)
    @Column(name = "prospect_name")
    private String prospectName;

    @NotEmpty
    @Size(max = 200)
    private String description;

    @Min(0)
    private BigDecimal value;

    public void update(final Oportunity payload) {
        this.prospectName = payload.getProspectName();
        this.description = payload.getDescription();
        this.value = payload.getValue();
    }
}
