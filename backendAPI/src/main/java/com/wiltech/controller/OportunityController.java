package com.wiltech.controller;

import com.wiltech.model.Oportunity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * The type Oportunity controller.
 */
@RestController
@RequestMapping("/oportunities")
public class OportunityController {

  /**
   * Get all list.
   *
   * @return the list
   */
  @GetMapping
  public List<Oportunity> getAll(){

    Oportunity oportunity = new Oportunity();
    oportunity.setId(1L);
    oportunity.setDescription("Senior software Engineer");
    oportunity.setProspectName("WilTech");
    oportunity.setValue(new BigDecimal(60_000));

    return Arrays.asList(oportunity);
  }
}
